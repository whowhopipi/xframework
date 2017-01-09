package com.xframework.boot.web.listener;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.xframework.boot.web.service.ApplicationVersionService;

@Component
public class ApplicationUpdateListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private List<ApplicationUpdateTask> tasks;
	@Autowired
	private ApplicationVersionService applicationVersionService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// 排序
		Collections.sort(tasks, new Comparator<ApplicationUpdateTask>() {
			@Override
			public int compare(ApplicationUpdateTask o1, ApplicationUpdateTask o2) {
				if (o1.preVersion() != o2.preVersion())
					return o1.preVersion() - o2.preVersion();
				return o1.currentVersion() - o2.currentVersion();
			}
		});

		for (ApplicationUpdateTask task : tasks) {
			if (task.preVersion() == applicationVersionService.currentVersion()) {
				task.update();
				applicationVersionService.updateVersion(task.currentVersion());
			}
		}

	}
}
