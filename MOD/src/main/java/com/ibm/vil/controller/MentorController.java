package com.ibm.vil.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.vil.data.model.Mentor;

@CrossOrigin
@Controller
@RequestMapping("/mentor")
public class MentorController {

	private static final Logger log = LoggerFactory.getLogger(MentorController.class);
	
	@RequestMapping(path="/detailsByName",produces="application/json")
	@ResponseBody
	public Mentor getMentorDetailsByName() {
		log.info("fetching Mentor details");
		Mentor mentor= new Mentor();
		mentor.setFullName("Ravi Jadhav");
		mentor.setExperiance(5);
		mentor.setAvgRating(4.2);
		mentor.setExpertInTechnls(new String[] {"Java","Spring","Angular","Bootstrap","CSS"});
		//mentor.setAdditionalTechnls(new String[] {"React","PHP"});
		mentor.setMentorId(1);
		mentor.setNoOfTrainingsDelivered(45);
		mentor.setPhoneNumber("92349032489");
		mentor.setTrainingBatchTimes(new String[] {"10:00 am-12:00 pm", "03:00 pm-05:00 pm"});	
		return mentor;
	}
}
