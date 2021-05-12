package fr.asterox.Mediscreen.restcontroller;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.Mediscreen.dto.PatientDTO;
import fr.asterox.Mediscreen.proxy.PatientManagementProxy;

@RestController
@RequestMapping("rest/patient")
public class PatientRestController {
	@Autowired
	PatientManagementProxy patientProxy;

	private static final Logger LOGGER = LogManager.getLogger(PatientRestController.class);

	@PostMapping
	public PatientDTO addPatient(@RequestBody PatientDTO patient) {
		LOGGER.info("Adding new user");
		return patientProxy.addPatient(patient);
	}

	@GetMapping(value = "/{id}")
	public PatientDTO getPatientById(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Getting patient identified by id");
		return patientProxy.getPatientById(patientId);
	}

	@PutMapping(value = "/{id}")
	public PatientDTO updatePatient(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId,
			@RequestBody PatientDTO patient) {
		LOGGER.info("Updating patient");
		return patientProxy.updatePatient(patientId, patient);
	}

	@DeleteMapping(value = "/{id}")
	public String deletePatientById(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Deleting patient");
		return patientProxy.deletePatientById(patientId);
	}
}
