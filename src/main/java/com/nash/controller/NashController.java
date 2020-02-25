package com.nash.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nash.patient.model.PatientInfo;
import com.nash.service.PatientListInfo;
import com.nash.service.PatientSendInfo;
import com.nash.service.PatientService;

@Controller
public class NashController {

	private PatientService ps;

	@RequestMapping(value = "nashhos", method = RequestMethod.GET)
	public ModelAndView showNashPatientInfo() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("pat-context");

		PatientInfo pi = new PatientInfo();
		mv.addObject("patients", pi);
		return mv;

	}

	@RequestMapping(value = "nashhos", method = RequestMethod.POST)
	public String dosignupPatient(PatientInfo pat) throws Exception {
		ps.savePatientInfo(pat);
		return "PatientLogin";

	}

	@RequestMapping(value = "pass", method = RequestMethod.GET)
	public ModelAndView needNashPatientInfo(@RequestParam String id) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("send-context");

		PatientInfo pi = ps.getPatientById(id);
		mv.addObject("hos", pi);
		return mv;
	}

	@RequestMapping(value = "editpat", method = RequestMethod.GET)
	public ModelAndView listPatient() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewmap");

		List<PatientInfo> pli = ps.getPatientInfo();
		mv.addObject("list", pli);
		return mv;
	}

	@RequestMapping(value = "editpage", method = RequestMethod.GET)
	public ModelAndView editNashPatient(@RequestParam String id) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("editsave-context");

		PatientInfo pinf = ps.getPatientById(id);
		mv.addObject("doedit", pinf);
		return mv;

	}

	@RequestMapping(value = "editsave", method = RequestMethod.POST)
	public String doupdatePatient(PatientInfo pal) throws Exception {
		ps.updateNashPatient(pal);
		return "PatientLogin";

	}

	public PatientService getPs() {
		return ps;
	}

	public void setPs(PatientService ps) {
		this.ps = ps;
	}

}
