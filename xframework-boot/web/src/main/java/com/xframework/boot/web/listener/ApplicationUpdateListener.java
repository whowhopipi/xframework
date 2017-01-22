package com.xframework.boot.web.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.xframework.boot.web.service.ApplicationVersionService;

@Component
public class ApplicationUpdateListener implements ApplicationListener<ContextRefreshedEvent> {

	private List<ApplicationUpdateTask> tasks = new ArrayList<>();
	@Autowired
	private ApplicationVersionService applicationVersionService;
	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		tasks.addAll(context.getBeansOfType(ApplicationUpdateTask.class).values());

		// 排序
		Collections.sort(tasks, new Comparator<ApplicationUpdateTask>() {
			@Override
			public int compare(ApplicationUpdateTask o1, ApplicationUpdateTask o2) {
				if (o1.preVersion() != o2.preVersion())
					return o1.preVersion() - o2.preVersion();
				return o1.currentVersion() - o2.currentVersion();
			}
		});
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		for (ApplicationUpdateTask task : tasks) {
			if (task.preVersion() == applicationVersionService.currentVersion()) {
				task.update();
				applicationVersionService.updateVersion(task.currentVersion());
			}
		}

	}
}
