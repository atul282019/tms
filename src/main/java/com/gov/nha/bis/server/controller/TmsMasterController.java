package com.gov.nha.bis.server.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gov.nha.bis.server.requestResponse.DocumentMasterRequest;
import com.gov.nha.bis.server.requestResponse.ImplantIDMasterRequest;
import com.gov.nha.bis.server.requestResponse.ImplantProcedureMappingRequest;
import com.gov.nha.bis.server.requestResponse.InvestigationMasterRequest;
import com.gov.nha.bis.server.requestResponse.InvestigationProcedureMappingRequest;
import com.gov.nha.bis.server.requestResponse.PackageCategoryMasterRequest;
import com.gov.nha.bis.server.requestResponse.PackageMasterRequest;
import com.gov.nha.bis.server.requestResponse.PriceMasterRequest;
import com.gov.nha.bis.server.requestResponse.ProcedureLabelMasterRequest;
import com.gov.nha.bis.server.requestResponse.ProcedureMasterRequest;
import com.gov.nha.bis.server.requestResponse.SpecialityMasterRequest;
import com.gov.nha.bis.server.requestResponse.StratificationMasterRequest;
import com.gov.nha.bis.server.requestResponse.StratificationProcedureMappingRequest;
import com.gov.nha.bis.server.requestResponse.VitalStatsProcedureMappingRequest;
import com.gov.nha.bis.server.requestResponse.VitalTestMasterRequest;
import com.gov.nha.bis.server.rest.service.TmsMasterService;

@CrossOrigin
@Controller
public class TmsMasterController extends NhaBisBaseController {

	@Autowired
	public TmsMasterService tmsMasterService;

	@GetMapping(value="/speciality")
	public ModelAndView getSpacility(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("spacility-master", "command", model);
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/masterPackage")
	public ModelAndView getPackage(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("package-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/packageCategory")
	public ModelAndView packageCategory(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("package-category-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/price")
	public ModelAndView getPrice(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("price-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/hospReference")
	public ModelAndView getHospitalSpecilialityMapper(Model model,HttpSession session) {
		return new ModelAndView("hospital-speciality-mapping", "command", "");
	}

	@GetMapping(value="/procedure")
	public ModelAndView getProcedure(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("procedure-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/lavelMaster")
	public ModelAndView getProcedureLavel(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("procedure-level-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/stratification")
	public ModelAndView getStratification(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("stratification-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/implant")
	public ModelAndView getImplant(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("implant-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);

	}

	@GetMapping(value="/document")
	public ModelAndView getDocumentMaster(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("document-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/scheme")
	public ModelAndView getScheme(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("scheme-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/vitaltestmaster")
	public ModelAndView getVItalTestMaster(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("vitaltest-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/investigation")
	public ModelAndView getInvestigationMaster(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("investigation-master", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}


	@GetMapping(value="/investigationprceduremap")
	public ModelAndView getInvestigationProcedureMapping(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("investigation-vs-procedure-mapp", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/vitaltestnprceduremap")
	public ModelAndView getVitaltestProcedureMapping(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("vitaltest-vs-procedure-mapping", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/impvspromapping")
	public ModelAndView getImplantVsProcedureMapping(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("implant-vs-procedure-mapping", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/stratvsprocmapping")
	public ModelAndView getStratificationVsProcedureMapping(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("stratification-vs-procedure-mapping", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/spacility-master-approval")
	public ModelAndView getSpecialityApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("spacility-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}
	
	@GetMapping(value="/package-master-approval")
	public ModelAndView getPackageMasterApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("package-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}
	
	@GetMapping(value="/getprocedure-master-approval")
	public ModelAndView getProcedureMasterApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("procedure-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}
	
	@GetMapping(value="/getprice-master-approval")
	public ModelAndView getpriceMasterApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("price-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/getimplantapproval")
	public ModelAndView getImplantApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("implant-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/getstratificationapproval")
	public ModelAndView getStratificationApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("stratification-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/getdocumentapproval")
	public ModelAndView getDocumentApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("document-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@GetMapping(value="/getinvestigationapproval")
	public ModelAndView getInvestigationApproval(Model model,HttpSession session) {
		String token = (String) session.getAttribute("loginToken");
		if(token!=null) {	
			model.addAttribute("role",(Integer) session.getAttribute("role"));
			return new ModelAndView("investigation-master-approval", "command", "");
		}
		return new ModelAndView("redirect:/login", "command", model);
	}

	@PostMapping(value="/saveInvestigationMasterData")
	public @ResponseBody String saveInvestigationMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("investigationMasterRequest") InvestigationMasterRequest investigationMasterRequest) {
		String response= null;
		response= tmsMasterService.saveInvestigationMaster(investigationMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveVitalTestMasterData")
	public @ResponseBody String saveVitalTestMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("vitalTestMasterRequest") VitalTestMasterRequest vitalTestMasterRequest) throws IOException{
		return tmsMasterService.saveVitalTestMasterData(vitalTestMasterRequest,(String) session.getAttribute("loginToken"));
	}	

	@PostMapping(value="/getVitalTestMasterData")
	public @ResponseBody String getVitalTestMasterData(HttpSession session,Model model) {
		return tmsMasterService.getVitalTestMasterData((String) session.getAttribute("loginToken"));
	}	

	@PostMapping(value="/getDataInvestigationMaster")
	public @ResponseBody String getInvestigationMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getInvestigationMasterData((String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/savePriceMasterData")
	public @ResponseBody String savePriceMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("priceMasterRequest") PriceMasterRequest priceMasterRequest) {
		String response= null;
		response= tmsMasterService.savePriceMaster(priceMasterRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getPriceMasterData")
	public @ResponseBody String getPriceMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPriceMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveSpecialityMasterData")
	public @ResponseBody String saveSpecialityMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("specialityMasterRequest") SpecialityMasterRequest specialityMasterRequest) {
		String response= null;
		response= tmsMasterService.saveSpecialityMasterData(specialityMasterRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getSpecialityMasterData")
	public @ResponseBody String getSpecialityMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getSpecialityMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/savePackageMasterData")
	public @ResponseBody String savePackageMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("packageMasterRequest") PackageMasterRequest packageMasterRequest) {
		String response= null;
		response= tmsMasterService.savePackageMasterData(packageMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getPackageMasterData")
	public @ResponseBody String getPackageMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPackageMasterData((String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/savePackageCategoryMasterData")
	public @ResponseBody String savePackageCategoryMaster(HttpSession session,HttpServletRequest request,@ModelAttribute("packageCategoryMasterRequest") PackageCategoryMasterRequest packageCategoryMasterRequest) {
		String response= null;
		response= tmsMasterService.savePackageCategoryMaster(packageCategoryMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getPackageCategoryMasterData")
	public @ResponseBody String getPackageCategoryMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPackageCategoryMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveProcedureMasterData")
	public @ResponseBody String saveProcedureMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("procedureMasterRequest") ProcedureMasterRequest procedureMasterRequest) {
		String response= null;
		response= tmsMasterService.saveProcedureMasterData(procedureMasterRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getProcedureMasterData")
	public @ResponseBody String getProcedureMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcedureMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getProcedureBySpecilityId")
	public @ResponseBody String getProcedureBySpecilityId(@RequestParam String specilitycode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcedureBySpecilityId(specilitycode,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/saveProcedureLabelMasterData")
	public @ResponseBody String saveProcedureLabelMaster(HttpSession session,HttpServletRequest request,@ModelAttribute("procedureLabelMasterRequest") ProcedureLabelMasterRequest procedureLabelMasterRequest) {
		String response= null;
		response= tmsMasterService.saveProcedureLabelMaster(procedureLabelMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getProcedureLabelMasterData")
	public @ResponseBody String getProcedureLabelMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcedureLabelMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveDocumentMasterData")
	public @ResponseBody String saveDocumentMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("documentMasterRequest") DocumentMasterRequest documentMasterRequest) {
		String response= null;
		response= tmsMasterService.saveDocumentMaster(documentMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getDocumentMasterData")
	public @ResponseBody String getDocumentMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getDocumentMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveImplantIDMasterData")
	public @ResponseBody String saveImplantIDMasterRequestData(HttpSession session,HttpServletRequest request,@ModelAttribute("implantIDMasterRequest") ImplantIDMasterRequest implantIDMasterRequest) {
		String response= null;
		response= tmsMasterService.saveImplantIDMasterRequestData(implantIDMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getImplantIDMasterData")
	public @ResponseBody String getImplantIDMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantIDMasterData((String) session.getAttribute("loginToken"));
		return response;			
	}	


	//get procedure distinct code and name 
	@PostMapping(value="/getprocedureList")
	public @ResponseBody String getprocedureList(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getprocedureList((String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/saveInvestigationProcedureMapping")
	public @ResponseBody String saveInvestigationProcedureMapping(HttpSession session,HttpServletRequest request,@ModelAttribute("investigationProcedureMappingRequest") InvestigationProcedureMappingRequest investigationProcedureMappingRequest) {
		String response= null;
		response= tmsMasterService.saveInvestigationProcedureMapping(investigationProcedureMappingRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getInvestigationProcedureMappingData")
	public @ResponseBody String getInvestigationProcedureMappingData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getInvestigationProcedureMappingData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/saveStratificationMasterRequestData")
	public @ResponseBody String saveStratificationMasterData(HttpSession session,HttpServletRequest request,@ModelAttribute("stratificationMasterRequest") StratificationMasterRequest stratificationMasterRequest) {
		String response= null;
		response= tmsMasterService.saveStratificationMasterData(stratificationMasterRequest,(String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getStratificationMasterRequestData")
	public @ResponseBody String getStratificationMasterRequestData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratificationMasterRequestData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getSchemeRequestData")
	public @ResponseBody String getSchemeMasterRequestData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getSchemeRequestData((String) session.getAttribute("loginToken"));
		return response;			
	}	

	@PostMapping(value="/getIdMasterData")
	public @ResponseBody String getIdMasterData(Model model,HttpSession session) {
		String response= null;
		response= tmsMasterService.getIdMasterData((String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getPackageMasterBySpecilityCode")
	public @ResponseBody String getPackageMasterBySpecilityCode(@RequestParam String specilitycode,HttpSession session,@RequestParam String statecode,@RequestParam Integer scheme) {
		String response= null;
		response= tmsMasterService.getPackageMasterBySpecilityCode(specilitycode,(String) session.getAttribute("loginToken"),statecode,scheme);
		return response;		
	}

	@PostMapping(value="/getprocedureMasterBySpecilityCodeAndPackageCodeByState")
	public @ResponseBody String getprocedureMasterBySpecilityCodeAndPackageCodeByState(@RequestParam String specilitycode,@RequestParam String packagecode,@RequestParam String statecode,HttpSession session,@RequestParam Integer scheme) {
		String response= null;
		response= tmsMasterService.getprocedureMasterBySpecilityCodeAndPackageCodeByState(specilitycode,packagecode,statecode,(String) session.getAttribute("loginToken"),scheme);
		return response;		
	}

	@PostMapping(value="/getInvestigationMasterBydPackageAndProcedureCode")
	public @ResponseBody String getInvestigationMasterBydPackageAndProcedureCode(@RequestParam String statecode,@RequestParam String procedurecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getInvestigationMasterBydPackageAndProcedureCode(statecode,procedurecode,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getStratificationMasterDataPreAuth")
	public @ResponseBody String getStratificationMasterDataPreAuth(@RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratificationMasterDataPreAuth(statecode,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getImplantMasterDataPreAuth")
	public @ResponseBody String getImplantMasterDataPreAuthByState(@RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantMasterDataPreAuthByState(statecode,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getStratificationDetailByStatificationCode")
	public @ResponseBody String getStratificationDetailByStatificationCode(@RequestParam String stratificationcode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratificationDetailByStatificationCode(stratificationcode,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getImplantDetailByImplantCode")
	public @ResponseBody String getImplantDetailByImplantId(@RequestParam String implantid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantDetailByImplantId(implantid,(String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/saveVitaltestProcedureMapping")
	public @ResponseBody String saveVitaltestProcedureMapping(HttpSession session,HttpServletRequest request,@ModelAttribute("vitalTestProcedureMappingRequest") VitalStatsProcedureMappingRequest vitalTestProcedureMappingRequest) {
		String response= null;
		response= tmsMasterService.saveVitaltestProcedureMapping(vitalTestProcedureMappingRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getVitaltestProcedureMappingData")
	public @ResponseBody String getVitaltestProcedureMappingData(HttpSession session) {
		String response= null;
		response= tmsMasterService.getVitaltestProcedureMappingData((String) session.getAttribute("loginToken"));
		return response;			
	}

	@PostMapping(value="/getImplantForProcedureMapByState")
	public @ResponseBody String getImplantForProcedureMapByState(@RequestParam String schemeid, @RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantForProcedureMapByState(schemeid,statecode,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getStratificationForProcedureMapByState")
	public @ResponseBody String getStratificationForProcedureMapByState(@RequestParam String schemeid, @RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratificationForProcedureMapByState(schemeid,statecode,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/saveImpProcMapping")
	public @ResponseBody String saveImpProcMapping(HttpSession session,HttpServletRequest request,@ModelAttribute("implantProcedureMappingRequest") ImplantProcedureMappingRequest implantProcedureMappingRequest) {
		String response= null;
		response= tmsMasterService.saveImpProcMapping(implantProcedureMappingRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getImpProcMapppingTableData")
	public @ResponseBody String getImpProcMapppingTableData(HttpSession session) {
		String response= null;
		response= tmsMasterService.getImpProcMapppingTableData((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/saveStratProcMapping")
	public @ResponseBody String saveStratProcMapping(HttpSession session,HttpServletRequest request,@ModelAttribute("stratificationProcedureMappingRequest") StratificationProcedureMappingRequest stratificationProcedureMappingRequest) {
		String response= null;
		response= tmsMasterService.saveStratProcMapping(stratificationProcedureMappingRequest,(String) session.getAttribute("loginToken"));
		return response;				
	}	

	@PostMapping(value="/getStratProcMapppingTableData")
	public @ResponseBody String getStratProcMapppingTableData(HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratProcMapppingTableData((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getInvestigationMasterForProcMappingData")
	public @ResponseBody String getInvestigationMasterForProcMappingData(@RequestParam String schemeid, @RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getInvestigationMasterForProcMappingData(schemeid,statecode,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getSpecialityBySchemeCoceAndStateCode")
	public @ResponseBody String getSpecialityBySchemeCoceAndStateCode(@RequestParam Integer schemeid, @RequestParam String statecode,HttpSession session) {
		String response= null;
		response= tmsMasterService.getSpecialityBySchemeCoceAndStateCode(schemeid,statecode,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getSpecialityDetailBySpecialityId")
	public @ResponseBody String getSpecialityDetailBySpecialityId(@RequestParam Integer specilityid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getSpecialityDetailBySpecialityId(specilityid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deleteSpecialityDetailBySpecialityId")
	public @ResponseBody String deleteSpecialityDetailBySpecialityId(@RequestParam Integer specilityid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deleteSpecialityDetailBySpecialityId(specilityid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getPackageDetailByPackageId")
	public @ResponseBody String getPackageDetailByPackageId(@RequestParam Long packageid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPackageDetailByPackageId(packageid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deletePackageDetailBypackageId")
	public @ResponseBody String deletePackageDetailByPackageId(@RequestParam Long packageid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deletePackageDetailByPackageId(packageid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getPackCategoryDetailByCategoryId")
	public @ResponseBody String getPackCategoryDetailByCategoryId(@RequestParam Integer packagecatid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPackCategoryDetailByCategoryId(packagecatid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deletePackCategoryDetailByCategoryId")
	public @ResponseBody String deletePackCategoryDetailByCategoryId(@RequestParam Integer packagecatid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deletePackCategoryDetailByCategoryId(packagecatid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getProcedureLabelDetailByProcedureLabelId")
	public @ResponseBody String getProcedureLabelDetailByProcedureLabelId(@RequestParam Integer procedurelblid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcedureLabelDetailByProcedureLabelId(procedurelblid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deleteProcedureLabelDetailByProcedureLabelId")
	public @ResponseBody String deleteProcedureLabelDetailByProcedureLabelId(@RequestParam Integer procedurelblid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deleteProcedureLabelDetailByProcedureLabelId(procedurelblid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getProcMasterForEditByProcId")
	public @ResponseBody String getProcMasterForEditByProcId(@RequestParam Long procedureid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcMasterForEditByProcId(procedureid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deleteProcMasterByProcId")
	public @ResponseBody String deleteProcMasterByProcId(@RequestParam Long procedureid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deleteProcMasterByProcId(procedureid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getPriceMasterDetailForEditByPriceId")
	public @ResponseBody String getPriceMasterDetailForEditByPriceId(@RequestParam Integer priceid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getPriceMasterDetailForEditByPriceId(priceid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deletePriceMasterByPriceId")
	public @ResponseBody String deletePriceDetailMasterByPriceId(@RequestParam Integer priceid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deletePriceDetailMasterByPriceId(priceid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getDocumetMasterDetailForEditByDocumentId")
	public @ResponseBody String getDocumetMasterDetailForEditByDocumentId(@RequestParam Long documentid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getDocumetMasterDetailForEditByDocumentId(documentid,(String) session.getAttribute("loginToken"));
		return response;		
	}


	@PostMapping(value="/deleteDocumentMasterByDocumentId")
	public @ResponseBody String deleteDocumentMasterByDocumentId(@RequestParam Long documentid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deleteDocumentMasterByDocumentId(documentid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getImplantMasterDetailForEditByImplantId")
	public @ResponseBody String getImplantMasterDetailForEditByImplantId(@RequestParam Integer implantid,HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantMasterDetailForEditByImplantId(implantid,(String) session.getAttribute("loginToken"));
		return response;		
	}	

	@PostMapping(value="/deleteImplantMasterByImplantId")
	public @ResponseBody String deleteImplantMasterByImplantId(@RequestParam Integer implantid,HttpSession session) {
		String response= null;
		response= tmsMasterService.deleteImplantMasterByImplantId(implantid,(String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/getStratificationMasterDetailByStratificationId")
	public @ResponseBody String getStratificationMasterDetailByStratificationId(@RequestParam Long stratificationid) {
		String response= null;
		response= tmsMasterService.getStratificationMasterDetailByStratificationId(stratificationid);
		return response;		
	}	

	@PostMapping(value="/deleteStratificationMasterByStratificationId")
	public @ResponseBody String deleteStratificationMasterByStratificationId(@RequestParam Long stratificationid) {
		String response= null;
		response= tmsMasterService.deleteStratificationMasterByStratificationId(stratificationid);
		return response;		
	}


	@PostMapping(value="/getInvestigationMasterDetailByInvestigationId")
	public @ResponseBody String getInvestigationMasterDetailByInvestigationId(@RequestParam Long investigationid) {
		String response= null;
		response= tmsMasterService.getInvestigationMasterDetailByInvestigationId(investigationid);
		return response;		
	}	

	@PostMapping(value="/deleteInvestigationMasterByInvestigationId")
	public @ResponseBody String deleteInvestigationMasterByInvestigationId(@RequestParam Integer investigationid) {
		String response= null;
		response= tmsMasterService.deleteInvestigationMasterByInvestigationId(investigationid);
		return response;		
	}

	@PostMapping(value="/getSpecialityMasterApproval")
	public @ResponseBody String getSpecialityMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getSpecialityMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveSpecialityMasterData")
	public @ResponseBody String approveSpecialityMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveSpecialityMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}



	@PostMapping(value="/getPackageMasterApproval")
	public @ResponseBody String getPackageMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getPackageMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approvePackageMasterData")
	public @ResponseBody String approvePackageMasterData(HttpSession session,@RequestParam Long packageid) {
		String response= null;
		response= tmsMasterService.approvePackageMasterData((String) session.getAttribute("loginToken"),packageid);
		return response;		
	}

	@PostMapping(value="/getprocedure-master-approval")
	public @ResponseBody String getProcedureMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getProcedureMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveProcedureMasterData")
	public @ResponseBody String approveProcedureMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveProcedureMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}

	@PostMapping(value="/getprice-master-approval")
	public @ResponseBody String getPriceMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getPriceMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approvePriceMasterData")
	public @ResponseBody String approvePriceMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approvePriceMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}

	@PostMapping(value="/getdocument-master-approval")
	public @ResponseBody String getDocumentMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getDocumentMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveDocumentMasterData")
	public @ResponseBody String approveDocumentMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveDocumentMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}

	@PostMapping(value="/getimplant-master-approval")
	public @ResponseBody String getImplantMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getImplantMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveImplantMasterData")
	public @ResponseBody String approveImplantMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveImplantMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}

	@PostMapping(value="/getstatification-master-approval")
	public @ResponseBody String getStratificationMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getStratificationMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveStratificationMasterData")
	public @ResponseBody String approveStratificationMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveStratificationMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}
	@PostMapping(value="/getinvestigation-master-approval")
	public @ResponseBody String getInvestigationMasterApproval(HttpSession session) {
		String response= null;
		response= tmsMasterService.getInvestigationMasterApproval((String) session.getAttribute("loginToken"));
		return response;		
	}

	@PostMapping(value="/approveInvestigationMasterData")
	public @ResponseBody String approveInvestigationMasterData(HttpSession session,@RequestParam Integer id) {
		String response= null;
		response= tmsMasterService.approveInvestigationMasterData((String) session.getAttribute("loginToken"),id);
		return response;		
	}

}


