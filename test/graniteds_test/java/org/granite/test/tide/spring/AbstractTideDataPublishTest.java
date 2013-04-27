package org.granite.test.tide.spring;

import javax.inject.Inject;

import org.granite.test.tide.data.Job;
import org.granite.test.tide.data.JobApplication;
import org.granite.test.tide.data.Meeting;
import org.granite.test.tide.spring.service.JobService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractTideDataPublishTest extends AbstractTideTestCase {

	@Inject
	private JobService jobService;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		jobService.init();
		initGravity();
	}
    
	@Test
    public void testPublish1() {
		Object[] result = jobService.apply(1, 1);
		
		Assert.assertNotNull(getLastMessage());
		Object[] updates = (Object[])getLastMessage().getBody();
		Assert.assertTrue("Updates count", updates.length >= 1);
		JobApplication application = (JobApplication)((Object[])updates[0])[1];
		// For some reason, 2 updates with JPA (PERSIST JobApplication + UPDATE Job)
		
		Job job = (Job)result[0];
		
		Assert.assertEquals("Job version", job.getVersion(), application.getJob().getVersion());
    }
    
	@Test
    public void testPublish2() {
		jobService.createMeeting(1, 1);
		
		Assert.assertNotNull(getLastMessage());
		Object[] updates = (Object[])getLastMessage().getBody();
		
		Assert.assertEquals("Updates count", 3, updates.length);
		Assert.assertTrue("Meeting", ((Object[])updates[0])[1] instanceof Meeting);
    }
}
