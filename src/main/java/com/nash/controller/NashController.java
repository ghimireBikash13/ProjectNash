package com.nash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nash.patient.model.PatientInfo;
import com.nash.service.PatientService;

@Controller
@RequestMapping("nashhos")
public class NashController {

	private PatientService ps;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showNashPatientInfo() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("pat-context");

		PatientInfo pi = new PatientInfo();
		mv.addObject("patients", pi);
		return mv;

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String dosignupPatient(PatientInfo pat) throws Exception {
		ps.savePatientInfo(pat);
		return "PatientLogin";

	}

	public PatientService getPs() {
		return ps;
	}

	public void setPs(PatientService ps) {
		this.ps = ps;
	}

}
