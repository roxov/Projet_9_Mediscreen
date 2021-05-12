package fr.asterox.Mediscreen.restcontroller;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.Mediscreen.proxy.ReportGeneratorProxy;

@RestController
@RequestMapping("rest/assess")
public class ReportRestController {

	private static final Logger LOGGER = LogManager.getLogger(ReportRestController.class);

	@Autowired
	private ReportGeneratorProxy reportGeneratorProxy;

	@GetMapping(value = "/{id}")
	public String getPatientAssessment(
			@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Getting diabetes report for patient identified by id : " + patientId);
		return reportGeneratorProxy.getPatientAssessment(patientId);
	}

}
