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
	private PatientSendInfo psi;
	private PatientListInfo pl;

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

		PatientInfo pi = psi.getPatientInfo(id);
		mv.addObject("hos", pi);
		return mv;
	}

	@RequestMapping(value = "editpat", method = RequestMethod.GET)
	public ModelAndView listPatient() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewmap");

		List<PatientInfo> pli = pl.getPatientInfo();
		mv.addObject("list", pli);
		return mv;
	}

	public PatientSendInfo getPsi() {
		return psi;
	}

	public void setPsi(PatientSendInfo psi) {
		this.psi = psi;
	}

	public PatientService getPs() {
		return ps;
	}

	public void setPs(PatientService ps) {
		this.ps = ps;
	}

	public PatientListInfo getPl() {
		return pl;
	}

	public void setPl(PatientListInfo pl) {
		this.pl = pl;
	}

}
