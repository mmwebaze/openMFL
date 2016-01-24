package org.jsi.mfl.dummies;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsi.mfl.api.domain.organisationunit.OrganisationUnit;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitLevel;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitOwner;
import org.jsi.mfl.api.domain.organisationunit.OrganisationUnitType;
import org.jsi.mfl.api.domain.servicetype.ServiceType;
import org.jsi.mfl.api.domain.user.User;

import scala.annotation.serializable;

public class DummyData {
	public static List<OrganisationUnitType> generateOrgUnitTypes(){
		List<OrganisationUnitType> orgUnitTypes = new ArrayList<>();
		OrganisationUnitType districtOffice = new OrganisationUnitType();
		districtOffice.setTypeName("District Office");
		orgUnitTypes.add(districtOffice);
		
		OrganisationUnitType clinic = new OrganisationUnitType();
		clinic.setTypeName("Clinic");
		orgUnitTypes.add(clinic);
		
		OrganisationUnitType hospital = new OrganisationUnitType();
		hospital.setTypeName("Hospital");
		orgUnitTypes.add(hospital);
		
		OrganisationUnitType healthCentre = new OrganisationUnitType();
		healthCentre.setTypeName("Health Centre");
		orgUnitTypes.add(healthCentre);
		
		OrganisationUnitType regionalOffice = new OrganisationUnitType();
		regionalOffice.setTypeName("Regional Office");
		orgUnitTypes.add(regionalOffice);
		
		OrganisationUnitType vct = new OrganisationUnitType();
		vct.setTypeName("VCT");
		orgUnitTypes.add(vct);
		
		OrganisationUnitType national = new OrganisationUnitType();
		national.setTypeName("National");
		orgUnitTypes.add(national);
		
		return orgUnitTypes;
	}
	
	public static List<OrganisationUnit> getOrgUnits(){
		
		List<OrganisationUnit> orgUnitList = new ArrayList<>();
				
		OrganisationUnit namibia = new OrganisationUnit();
		namibia.setOrganisationUnitName("Namibia");
		namibia.setOrganisationUnitCode("10576");
		namibia.setOrganisationUnitLevel(new OrganisationUnitLevel(1));
		orgUnitList.add(namibia);

		OrganisationUnit karasRegion = new OrganisationUnit();
		karasRegion.setOrganisationUnitName("!Karas Region");
		karasRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		karasRegion.setOrganisationUnitCode("10579");
		karasRegion.setParent(namibia);
		orgUnitList.add(karasRegion);

		OrganisationUnit naminusDistrict = new OrganisationUnit();
		naminusDistrict.setOrganisationUnitName("ǃNamiǂNûs District");
		naminusDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		naminusDistrict.setOrganisationUnitCode("10601");
		naminusDistrict.setParent(karasRegion);
		orgUnitList.add(naminusDistrict);
		
		//NamiNus Facilities
		OrganisationUnit ausClinic = new OrganisationUnit();
		ausClinic.setOrganisationUnitName("Aus Clinic");
		ausClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ausClinic.setOrganisationUnitCode("10207");
		ausClinic.setParent(naminusDistrict);
		orgUnitList.add(ausClinic);
			
		OrganisationUnit ElizabethBayClinic = new OrganisationUnit();
		ElizabethBayClinic.setOrganisationUnitName("Elizabeth Bay Clinic");
		ElizabethBayClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ElizabethBayClinic.setOrganisationUnitCode("10213");
		ElizabethBayClinic.setParent(naminusDistrict);
		orgUnitList.add(ElizabethBayClinic);

			
		OrganisationUnit LuderitzDistrictHospital = new OrganisationUnit();
		LuderitzDistrictHospital.setOrganisationUnitName("Luderitz District Hospital");
		LuderitzDistrictHospital.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		LuderitzDistrictHospital.setOrganisationUnitCode("10221");
		LuderitzDistrictHospital.setParent(naminusDistrict);
		orgUnitList.add(LuderitzDistrictHospital);

		OrganisationUnit LuderitzClinic = new OrganisationUnit();
		LuderitzClinic.setOrganisationUnitName("Luderitz Clinic");
		LuderitzClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		LuderitzClinic.setOrganisationUnitCode("10222");
		LuderitzClinic.setParent(naminusDistrict);
		orgUnitList.add(LuderitzClinic);

		OrganisationUnit NamdebHospital = new OrganisationUnit();
		NamdebHospital.setOrganisationUnitName("Namdeb Hospital");
		NamdebHospital.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		NamdebHospital.setOrganisationUnitCode("10223");
		NamdebHospital.setParent(naminusDistrict);
		orgUnitList.add(NamdebHospital);

		OrganisationUnit OranjemundPrimaryHealthCare = new OrganisationUnit();
		OranjemundPrimaryHealthCare.setOrganisationUnitName("Oranjemund Primary Health Care clinic (Part of Namdeb Hospital)");
		OranjemundPrimaryHealthCare.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		OranjemundPrimaryHealthCare.setOrganisationUnitCode("10225");
		OranjemundPrimaryHealthCare.setParent(naminusDistrict);
		orgUnitList.add(OranjemundPrimaryHealthCare);

		OrganisationUnit PocketBeachesClinic = new OrganisationUnit();
		PocketBeachesClinic.setOrganisationUnitName("Pocket Beaches Clinic");
		PocketBeachesClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		PocketBeachesClinic.setOrganisationUnitCode("10226");
		PocketBeachesClinic.setParent(naminusDistrict);
		orgUnitList.add(PocketBeachesClinic);

		OrganisationUnit RoschemClinic = new OrganisationUnit();
		RoschemClinic.setOrganisationUnitName("Roschem Clinic");
		RoschemClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		RoschemClinic.setOrganisationUnitCode("10227");
		RoschemClinic.setParent(naminusDistrict);
		orgUnitList.add(RoschemClinic);

		OrganisationUnit RoshCareClinic = new OrganisationUnit();
		RoshCareClinic.setOrganisationUnitName("Rosh Care Clinic");
		RoshCareClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		RoshCareClinic.setOrganisationUnitCode("10228");
		RoshCareClinic.setParent(naminusDistrict);
		orgUnitList.add(RoshCareClinic);

		OrganisationUnit RoshPinahClinic = new OrganisationUnit();
		RoshPinahClinic.setOrganisationUnitName("Rosh Pinah Clinic");
		RoshPinahClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		RoshPinahClinic.setOrganisationUnitCode("10229");
		RoshPinahClinic.setParent(naminusDistrict);
		orgUnitList.add(RoshPinahClinic);

		OrganisationUnit SedadicClinic = new OrganisationUnit();
		SedadicClinic.setOrganisationUnitName("Sedadic Clinic");
		SedadicClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SedadicClinic.setOrganisationUnitCode("10230");
		SedadicClinic.setParent(naminusDistrict);
		orgUnitList.add(SedadicClinic);

		OrganisationUnit OranjemundClinic = new OrganisationUnit();
		OranjemundClinic.setOrganisationUnitName("Oranjemund Clinic");
		OranjemundClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		OranjemundClinic.setOrganisationUnitCode("10233");
		OranjemundClinic.setParent(naminusDistrict);
		orgUnitList.add(OranjemundClinic);

		OrganisationUnit keetmanshoopDistrict = new OrganisationUnit();
		keetmanshoopDistrict.setOrganisationUnitName("Keetmanshoop District");
		keetmanshoopDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		keetmanshoopDistrict.setOrganisationUnitCode("10599");
		keetmanshoopDistrict.setParent(karasRegion);
		orgUnitList.add(keetmanshoopDistrict);

		//Keetmanshoop district facilities
		OrganisationUnit AroabHealthCentre = new OrganisationUnit();
		AroabHealthCentre.setOrganisationUnitName("Aroab Health Centre");
		AroabHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		AroabHealthCentre.setOrganisationUnitCode("10206");
		AroabHealthCentre.setParent(keetmanshoopDistrict);
		orgUnitList.add(AroabHealthCentre);

		OrganisationUnit BersebaClinic = new OrganisationUnit();
		BersebaClinic.setOrganisationUnitName("Berseba Clinic");
		BersebaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		BersebaClinic.setOrganisationUnitCode("10209");
		BersebaClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(BersebaClinic);

		OrganisationUnit BethanienHealthCentre = new OrganisationUnit();
		BethanienHealthCentre.setOrganisationUnitName("Bethanien Health Centre");
		BethanienHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		BethanienHealthCentre.setOrganisationUnitCode("10210");
		BethanienHealthCentre.setParent(keetmanshoopDistrict);
		orgUnitList.add(BethanienHealthCentre);

		OrganisationUnit BrukarosClinic = new OrganisationUnit();
		BrukarosClinic.setOrganisationUnitName("Brukaros Clinic");
		BrukarosClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		BrukarosClinic.setOrganisationUnitCode("10211");
		BrukarosClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(BrukarosClinic);

		OrganisationUnit DaanViljoenClinic = new OrganisationUnit();
		DaanViljoenClinic.setOrganisationUnitName("Daan Viljoen Clinic");
		DaanViljoenClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		DaanViljoenClinic.setOrganisationUnitCode("10212");
		DaanViljoenClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(DaanViljoenClinic);

		OrganisationUnit KeetmanshoopPrivateClinic = new OrganisationUnit();
		KeetmanshoopPrivateClinic.setOrganisationUnitName("Keetmanshoop Private Clinic");
		KeetmanshoopPrivateClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KeetmanshoopPrivateClinic.setOrganisationUnitCode("10216");
		KeetmanshoopPrivateClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(KeetmanshoopPrivateClinic);

		OrganisationUnit KeetmanshoopTseiblaagteClinic = new OrganisationUnit();
		KeetmanshoopTseiblaagteClinic.setOrganisationUnitName("Keetmanshoop/Tseiblaagte Clinic");
		KeetmanshoopTseiblaagteClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KeetmanshoopTseiblaagteClinic.setOrganisationUnitCode("10217");
		KeetmanshoopTseiblaagteClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(KeetmanshoopTseiblaagteClinic);

		OrganisationUnit KetmanshoopDistrictHospital = new OrganisationUnit();
		KetmanshoopDistrictHospital.setOrganisationUnitName("Ketmanshoop District Hospital");
		KetmanshoopDistrictHospital.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KetmanshoopDistrictHospital.setOrganisationUnitCode("10218");
		KetmanshoopDistrictHospital.setParent(keetmanshoopDistrict);
		orgUnitList.add(KetmanshoopDistrictHospital);

		OrganisationUnit KhabuserClinic = new OrganisationUnit();
		KhabuserClinic.setOrganisationUnitName("Khabuser  Clinic");
		KhabuserClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KhabuserClinic.setOrganisationUnitCode("10219");
		KhabuserClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(KhabuserClinic);

		OrganisationUnit KoesClinic = new OrganisationUnit();
		KoesClinic.setOrganisationUnitName("Koes Clinic");
		KoesClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KoesClinic.setOrganisationUnitCode("10220");
		KoesClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(KoesClinic);

		OrganisationUnit TsesClinic = new OrganisationUnit();
		TsesClinic.setOrganisationUnitName("Tses Clinic");
		TsesClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		TsesClinic.setOrganisationUnitCode("10231");
		TsesClinic.setParent(keetmanshoopDistrict);
		orgUnitList.add(TsesClinic);

		OrganisationUnit karasburgDistrict = new OrganisationUnit();
		karasburgDistrict.setOrganisationUnitName("Karasburg District");
		karasburgDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		karasburgDistrict.setOrganisationUnitCode("10597");
		karasburgDistrict.setParent(karasRegion);
		orgUnitList.add(karasburgDistrict);
		
		//Karasburg district facilities
		OrganisationUnit AriamsvleiClinic = new OrganisationUnit();
		AriamsvleiClinic.setOrganisationUnitName("Ariamsvlei Clinic");
		AriamsvleiClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		AriamsvleiClinic.setOrganisationUnitCode("10205");
		AriamsvleiClinic.setParent(karasburgDistrict);
		orgUnitList.add(AriamsvleiClinic);

		OrganisationUnit AussenkerClinic = new OrganisationUnit();
		AussenkerClinic.setOrganisationUnitName("Aussenker Clinic");
		AussenkerClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		AussenkerClinic.setOrganisationUnitCode("10208");
		AussenkerClinic.setParent(karasburgDistrict);
		orgUnitList.add(AussenkerClinic);

		OrganisationUnit KarasburgClinic = new OrganisationUnit();
		KarasburgClinic.setOrganisationUnitName("Karasburg Clinic");
		KarasburgClinic	.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KarasburgClinic	.setOrganisationUnitCode("10214");
		KarasburgClinic	.setParent(karasburgDistrict);
		orgUnitList.add(KarasburgClinic);

		OrganisationUnit KarasburgDistrictHospital	 = new OrganisationUnit();
		KarasburgDistrictHospital.setOrganisationUnitName("Karasburg District Hospital");
		KarasburgDistrictHospital.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KarasburgDistrictHospital.setOrganisationUnitCode("10215");
		KarasburgDistrictHospital.setParent(karasburgDistrict);
		orgUnitList.add(KarasburgDistrictHospital);

		OrganisationUnit NoordoewerHealthCentre	 = new OrganisationUnit();
		NoordoewerHealthCentre.setOrganisationUnitName("Noordoewer Health Centre");
		NoordoewerHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		NoordoewerHealthCentre.setOrganisationUnitCode("10224");
		NoordoewerHealthCentre.setParent(karasburgDistrict);
		orgUnitList.add(NoordoewerHealthCentre);

		OrganisationUnit WarmbadClinic	 = new OrganisationUnit();
		WarmbadClinic.setOrganisationUnitName("Warmbad Clinic");
		WarmbadClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		WarmbadClinic.setOrganisationUnitCode("10232");
		WarmbadClinic.setParent(karasburgDistrict);
		orgUnitList.add(WarmbadClinic);

		OrganisationUnit GabisClinic	 = new OrganisationUnit();
		GabisClinic.setOrganisationUnitName("Gabis Clinic");
		GabisClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		GabisClinic.setOrganisationUnitCode("10553");
		GabisClinic.setParent(karasburgDistrict);
		orgUnitList.add(GabisClinic);

		OrganisationUnit roshPinahDistrict = new OrganisationUnit();
		roshPinahDistrict.setOrganisationUnitName("Rosh Pinah District");
		roshPinahDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		roshPinahDistrict.setOrganisationUnitCode("10639");
		roshPinahDistrict.setParent(karasRegion);
		orgUnitList.add(roshPinahDistrict);

		OrganisationUnit erongoRegion = new OrganisationUnit();
		erongoRegion.setOrganisationUnitName("Erongo Region");
		erongoRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		erongoRegion.setOrganisationUnitCode("10577");
		erongoRegion.setParent(namibia);
		orgUnitList.add(erongoRegion);

		OrganisationUnit omaruruDistrict = new OrganisationUnit();
		omaruruDistrict.setOrganisationUnitName("Omaruru District");
		omaruruDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		omaruruDistrict.setOrganisationUnitCode("10609");
		omaruruDistrict.setParent(erongoRegion);
		orgUnitList.add(omaruruDistrict);

		OrganisationUnit SwakopmundDistrict = new OrganisationUnit();
		SwakopmundDistrict.setOrganisationUnitName("Swakopmund District");
		SwakopmundDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		SwakopmundDistrict.setOrganisationUnitCode("10620");
		SwakopmundDistrict.setParent(erongoRegion);
		orgUnitList.add(SwakopmundDistrict);

		OrganisationUnit UsakosDistrict = new OrganisationUnit();
		UsakosDistrict.setOrganisationUnitName("Usakos District");
		UsakosDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		UsakosDistrict.setOrganisationUnitCode("10623");
		UsakosDistrict.setParent(erongoRegion);
		orgUnitList.add(UsakosDistrict);

		OrganisationUnit WalvisBayDistrict = new OrganisationUnit();
		WalvisBayDistrict.setOrganisationUnitName("Walvis Bay District");
		WalvisBayDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		WalvisBayDistrict.setOrganisationUnitCode("10624");
		WalvisBayDistrict.setParent(erongoRegion);
		orgUnitList.add(WalvisBayDistrict);
			
		OrganisationUnit hardapRegion = new OrganisationUnit();
		hardapRegion.setOrganisationUnitName("Hardap Region");
		hardapRegion.setOrganisationUnitCode("10578");
		hardapRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		hardapRegion.setParent(namibia);
		orgUnitList.add(hardapRegion);

		OrganisationUnit AranosDistrict = new OrganisationUnit();
		AranosDistrict.setOrganisationUnitName("Aranos District");
		AranosDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		AranosDistrict.setOrganisationUnitCode("10592");
		AranosDistrict.setParent(hardapRegion);
		orgUnitList.add(AranosDistrict);

		OrganisationUnit MarientalDistrict = new OrganisationUnit();
		MarientalDistrict.setOrganisationUnitName("Mariental District");
		MarientalDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		MarientalDistrict.setOrganisationUnitCode("10602");
		MarientalDistrict.setParent(hardapRegion);
		orgUnitList.add(MarientalDistrict);

		OrganisationUnit RehobothDistrict = new OrganisationUnit();
		RehobothDistrict.setOrganisationUnitName("Rehoboth District");
		RehobothDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		RehobothDistrict.setOrganisationUnitCode("10618");
		RehobothDistrict.setParent(hardapRegion);
		orgUnitList.add(RehobothDistrict);

		OrganisationUnit kavangoEastRegion = new OrganisationUnit();
		kavangoEastRegion.setOrganisationUnitName("Kavango East Region");
		kavangoEastRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		kavangoEastRegion.setOrganisationUnitCode("10580");
		kavangoEastRegion.setParent(namibia);
		orgUnitList.add(kavangoEastRegion);

		OrganisationUnit AndaraDistrict = new OrganisationUnit();
		AndaraDistrict.setOrganisationUnitName("Andara District");
		AndaraDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		AndaraDistrict.setOrganisationUnitCode("10591");
		AndaraDistrict.setParent(kavangoEastRegion);
		orgUnitList.add(AndaraDistrict);

		OrganisationUnit NyanganaDistrict = new OrganisationUnit();
		NyanganaDistrict.setOrganisationUnitName("Nyangana District");
		NyanganaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		NyanganaDistrict.setOrganisationUnitCode("10604");
		NyanganaDistrict.setParent(kavangoEastRegion);
		orgUnitList.add(NyanganaDistrict);

		OrganisationUnit RunduDistrict = new OrganisationUnit();
		RunduDistrict.setOrganisationUnitName("Rundu District");
		RunduDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		RunduDistrict.setOrganisationUnitCode("10619");
		RunduDistrict.setParent(kavangoEastRegion);
		orgUnitList.add(RunduDistrict);

		OrganisationUnit kavangoWestRegion = new OrganisationUnit();
		kavangoWestRegion.setOrganisationUnitName("Kavango West Region");
		kavangoWestRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		kavangoWestRegion.setOrganisationUnitCode("10581");
		kavangoWestRegion.setParent(namibia);
		orgUnitList.add(kavangoWestRegion);

		OrganisationUnit NankuduDistrict = new OrganisationUnit();
		NankuduDistrict.setOrganisationUnitName("Nankudu District");
		NankuduDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		NankuduDistrict.setOrganisationUnitCode("10603");
		NankuduDistrict.setParent(kavangoWestRegion);
		orgUnitList.add(NankuduDistrict);

		OrganisationUnit NcamangoroDistrict = new OrganisationUnit();
		NcamangoroDistrict.setOrganisationUnitName("Ncamangoro District");
		NcamangoroDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		NcamangoroDistrict.setOrganisationUnitCode("10643");
		NcamangoroDistrict.setParent(kavangoWestRegion);
		orgUnitList.add(NcamangoroDistrict);

		OrganisationUnit NkurenkuruDistrict = new OrganisationUnit();
		NkurenkuruDistrict.setOrganisationUnitName("Nkurenkuru District");
		NkurenkuruDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		NkurenkuruDistrict.setOrganisationUnitCode("10644");
		NkurenkuruDistrict.setParent(kavangoWestRegion);
		orgUnitList.add(NkurenkuruDistrict);
			
		OrganisationUnit khomasRegion = new OrganisationUnit();
		khomasRegion.setOrganisationUnitName("Khomas Region");
		khomasRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		khomasRegion.setOrganisationUnitCode("10582");
		khomasRegion.setParent(namibia);
		orgUnitList.add(khomasRegion);

		OrganisationUnit WindhoekDistrict = new OrganisationUnit();
		WindhoekDistrict.setOrganisationUnitName("Windhoek District");
		WindhoekDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		WindhoekDistrict.setOrganisationUnitCode("10625");
		WindhoekDistrict.setParent(khomasRegion);
		orgUnitList.add(WindhoekDistrict);


		OrganisationUnit kuneneRegion = new OrganisationUnit();
		kuneneRegion.setOrganisationUnitName("Kunene Region");
		kuneneRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		kuneneRegion.setOrganisationUnitCode("10583");
		kuneneRegion.setParent(namibia);
		orgUnitList.add(kuneneRegion);

		OrganisationUnit KhorixasDistrict = new OrganisationUnit();
		KhorixasDistrict.setOrganisationUnitName("Khorixas District");
		KhorixasDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		KhorixasDistrict.setOrganisationUnitCode("10600");
		KhorixasDistrict.setParent(kuneneRegion);
		orgUnitList.add(KhorixasDistrict);

		OrganisationUnit OpuwoDistrict = new OrganisationUnit();
		OpuwoDistrict.setOrganisationUnitName("Opuwo District");
		OpuwoDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OpuwoDistrict.setOrganisationUnitCode("10612");
		OpuwoDistrict.setParent(kuneneRegion);
		orgUnitList.add(OpuwoDistrict);

		OrganisationUnit OutjoDistrict = new OrganisationUnit();
		OutjoDistrict.setOrganisationUnitName("Outjo District");
		OutjoDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OutjoDistrict.setOrganisationUnitCode("10617");
		OutjoDistrict.setParent(kuneneRegion);
		orgUnitList.add(OutjoDistrict);

		OrganisationUnit ohangwenaRegion = new OrganisationUnit();
		ohangwenaRegion.setOrganisationUnitName("Ohangwena Region");
		ohangwenaRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		ohangwenaRegion.setOrganisationUnitCode("10584");
		ohangwenaRegion.setParent(namibia);
		orgUnitList.add(ohangwenaRegion);

		OrganisationUnit EenhanaDistrict = new OrganisationUnit();
		EenhanaDistrict.setOrganisationUnitName("Eenhana District");
		EenhanaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		EenhanaDistrict.setOrganisationUnitCode("10593");
		EenhanaDistrict.setParent(ohangwenaRegion);
		orgUnitList.add(EenhanaDistrict);

		OrganisationUnit EngelaDistrict = new OrganisationUnit();
		EngelaDistrict.setOrganisationUnitName("Engela District");
		EngelaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		EngelaDistrict.setOrganisationUnitCode("10594");
		EngelaDistrict.setParent(ohangwenaRegion);
		orgUnitList.add(EngelaDistrict);

		OrganisationUnit OkongoDistrict = new OrganisationUnit();
		OkongoDistrict.setOrganisationUnitName("Okongo District");
		OkongoDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OkongoDistrict.setOrganisationUnitCode("10608");
		OkongoDistrict.setParent(ohangwenaRegion);
		orgUnitList.add(OkongoDistrict);

		OrganisationUnit omahekeRegion = new OrganisationUnit();
		omahekeRegion.setOrganisationUnitName("Omaheke Region");
		omahekeRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		omahekeRegion.setOrganisationUnitCode("10585");
		omahekeRegion.setParent(namibia);
		orgUnitList.add(omahekeRegion);

		OrganisationUnit GobabisDistrict = new OrganisationUnit();
		GobabisDistrict.setOrganisationUnitName("Gobabis District");
		GobabisDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		GobabisDistrict.setOrganisationUnitCode("10595");
		GobabisDistrict.setParent(omahekeRegion);
		orgUnitList.add(GobabisDistrict);
		

		OrganisationUnit omusatiRegion = new OrganisationUnit();
		omusatiRegion.setOrganisationUnitName("Omusati Region");
		omusatiRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		omusatiRegion.setOrganisationUnitCode("10586");
		omusatiRegion.setParent(namibia);
		orgUnitList.add(omusatiRegion);

		OrganisationUnit OkahaoDistrict = new OrganisationUnit();
		OkahaoDistrict.setOrganisationUnitName("Okahao District");
		OkahaoDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OkahaoDistrict.setOrganisationUnitCode("10606");
		OkahaoDistrict.setParent(omusatiRegion);
		orgUnitList.add(OkahaoDistrict);

		OrganisationUnit OshikukuDistrict = new OrganisationUnit();
		OshikukuDistrict.setOrganisationUnitName("Oshikuku District");
		OshikukuDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OshikukuDistrict.setOrganisationUnitCode("10614");
		OshikukuDistrict.setParent(omusatiRegion);
		orgUnitList.add(OshikukuDistrict);

		OrganisationUnit OutapiDistrict = new OrganisationUnit();
		OutapiDistrict.setOrganisationUnitName("Outapi District");
		OutapiDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OutapiDistrict.setOrganisationUnitCode("10616");
		OutapiDistrict.setParent(omusatiRegion);
		orgUnitList.add(OutapiDistrict);

		OrganisationUnit TsandiDistrict = new OrganisationUnit();
		TsandiDistrict.setOrganisationUnitName("Tsandi District");
		TsandiDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		TsandiDistrict.setOrganisationUnitCode("10606");
		TsandiDistrict.setParent(omusatiRegion);
		orgUnitList.add(TsandiDistrict);

		OrganisationUnit oshanaRegion = new OrganisationUnit();
		oshanaRegion.setOrganisationUnitName("Oshana Region");
		oshanaRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		oshanaRegion.setOrganisationUnitCode("10587");
		oshanaRegion.setParent(namibia);
		orgUnitList.add(oshanaRegion);

		OrganisationUnit OndangwaDistrict = new OrganisationUnit();
		OndangwaDistrict.setOrganisationUnitName("Ondangwa District");
		OndangwaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OndangwaDistrict.setOrganisationUnitCode("10640");
		OndangwaDistrict.setParent(oshanaRegion);
		orgUnitList.add(OndangwaDistrict);

		OrganisationUnit OshakatiDistrict = new OrganisationUnit();
		OshakatiDistrict.setOrganisationUnitName("Oshakati District");
		OshakatiDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OshakatiDistrict.setOrganisationUnitCode("10613");
		OshakatiDistrict.setParent(oshanaRegion);
		orgUnitList.add(OshakatiDistrict);

		OrganisationUnit oshikotoRegion = new OrganisationUnit();
		oshikotoRegion.setOrganisationUnitName("Oshikoto Region");
		oshikotoRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		oshikotoRegion.setOrganisationUnitCode("10588");
		oshikotoRegion.setParent(namibia);
		orgUnitList.add(oshikotoRegion);

		OrganisationUnit OmuthiyaDistrict = new OrganisationUnit();
		OmuthiyaDistrict.setOrganisationUnitName("Omuthiya District");
		OmuthiyaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OmuthiyaDistrict.setOrganisationUnitCode("10610");
		OmuthiyaDistrict.setParent(oshikotoRegion);
		orgUnitList.add(OmuthiyaDistrict);

		OrganisationUnit OnandjokweDistrict = new OrganisationUnit();
		OnandjokweDistrict.setOrganisationUnitName("Onandjokwe District");
		OnandjokweDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OnandjokweDistrict.setOrganisationUnitCode("10611");
		OnandjokweDistrict.setParent(oshikotoRegion);
		orgUnitList.add(OnandjokweDistrict);

		OrganisationUnit TsumebDistrict = new OrganisationUnit();
		TsumebDistrict.setOrganisationUnitName("Tsumeb District");
		TsumebDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		TsumebDistrict.setOrganisationUnitCode("10622");
		TsumebDistrict.setParent(oshikotoRegion);
		orgUnitList.add(TsumebDistrict);

		OrganisationUnit otjozondjupatoRegion = new OrganisationUnit();
		otjozondjupatoRegion.setOrganisationUnitName("Otjozondjupa Region");
		otjozondjupatoRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		otjozondjupatoRegion.setOrganisationUnitCode("10589");
		otjozondjupatoRegion.setParent(namibia);
		orgUnitList.add(otjozondjupatoRegion);

		OrganisationUnit GrootfonteinDistrict = new OrganisationUnit();
		GrootfonteinDistrict.setOrganisationUnitName("Grootfontein District");
		GrootfonteinDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		GrootfonteinDistrict.setOrganisationUnitCode("10596");
		GrootfonteinDistrict.setParent(otjozondjupatoRegion);
		orgUnitList.add(GrootfonteinDistrict);

		OrganisationUnit OkahandjaDistrict = new OrganisationUnit();
		OkahandjaDistrict.setOrganisationUnitName("Okahandja District");
		OkahandjaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OkahandjaDistrict.setOrganisationUnitCode("10605");
		OkahandjaDistrict.setParent(otjozondjupatoRegion);
		orgUnitList.add(OkahandjaDistrict);

		OrganisationUnit OkakararaDistrict = new OrganisationUnit();
		OkakararaDistrict.setOrganisationUnitName("Okakarara District");
		OkakararaDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OkakararaDistrict.setOrganisationUnitCode("10607");
		OkakararaDistrict.setParent(otjozondjupatoRegion);
		orgUnitList.add(OkakararaDistrict);

		OrganisationUnit OtjiwarongoDistrict = new OrganisationUnit();
		OtjiwarongoDistrict.setOrganisationUnitName("Otjiwarongo District");
		OtjiwarongoDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		OtjiwarongoDistrict.setOrganisationUnitCode("10615");
		OtjiwarongoDistrict.setParent(otjozondjupatoRegion);
		orgUnitList.add(OtjiwarongoDistrict);

		OrganisationUnit TsumkweDistrict = new OrganisationUnit();
		TsumkweDistrict.setOrganisationUnitName("Tsumkwe District");
		TsumkweDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		TsumkweDistrict.setOrganisationUnitCode("10642");
		TsumkweDistrict.setParent(otjozondjupatoRegion);
		orgUnitList.add(TsumkweDistrict);

		OrganisationUnit zambeziRegion = new OrganisationUnit();
		zambeziRegion.setOrganisationUnitName("Zambezi Region");
		zambeziRegion.setOrganisationUnitLevel(new OrganisationUnitLevel(2));
		zambeziRegion.setOrganisationUnitCode("10590");
		zambeziRegion.setParent(namibia);
		orgUnitList.add(zambeziRegion);

		OrganisationUnit KatimaMuliloDistrict = new OrganisationUnit();
		KatimaMuliloDistrict.setOrganisationUnitName("Katima Mulilo District");
		KatimaMuliloDistrict.setOrganisationUnitLevel(new OrganisationUnitLevel(3));
		KatimaMuliloDistrict.setOrganisationUnitCode("10598");
		KatimaMuliloDistrict.setParent(zambeziRegion);
		orgUnitList.add(KatimaMuliloDistrict);
		
		//Katima Mulilo District
		OrganisationUnit BatubajaClinic = new OrganisationUnit();
		BatubajaClinic.setOrganisationUnitName("Batubaja Clinic");
		BatubajaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		BatubajaClinic.setOrganisationUnitCode("10101");
		BatubajaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(BatubajaClinic);
				
		OrganisationUnit BukaloHealthCentre = new OrganisationUnit();
		BukaloHealthCentre.setOrganisationUnitName("Bukalo Health Centre");
		BukaloHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		BukaloHealthCentre.setOrganisationUnitCode("10102");
		BukaloHealthCentre.setParent(KatimaMuliloDistrict);
		orgUnitList.add(BukaloHealthCentre);

		OrganisationUnit ChettoClinic = new OrganisationUnit();
		ChettoClinic.setOrganisationUnitName("Chetto Clinic");
		ChettoClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ChettoClinic.setOrganisationUnitCode("10103");
		ChettoClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(ChettoClinic);

		OrganisationUnit ChinchimaniClinic = new OrganisationUnit();
		ChinchimaniClinic.setOrganisationUnitName("Chinchimani Clinic");
		ChinchimaniClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ChinchimaniClinic.setOrganisationUnitCode("10104");
		ChinchimaniClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(ChinchimaniClinic);

		OrganisationUnit ChoiClinic = new OrganisationUnit();
		ChoiClinic.setOrganisationUnitName("Choi Clinic");
		ChoiClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ChoiClinic.setOrganisationUnitCode("10105");
		ChoiClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(ChoiClinic);

		OrganisationUnit GoodHealthMedical = new OrganisationUnit();
		GoodHealthMedical.setOrganisationUnitName("Good Health Medical Health Centre");
		GoodHealthMedical.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		GoodHealthMedical.setOrganisationUnitCode("10106");
		GoodHealthMedical.setParent(KatimaMuliloDistrict);
		orgUnitList.add(GoodHealthMedical);

		OrganisationUnit IbbuClinic = new OrganisationUnit();
		IbbuClinic.setOrganisationUnitName("Ibbu Clinic");
		IbbuClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		IbbuClinic.setOrganisationUnitCode("10107");
		IbbuClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(IbbuClinic);

		OrganisationUnit ImpalilaClinic = new OrganisationUnit();
		ImpalilaClinic.setOrganisationUnitName("Impalila Clinic");
		ImpalilaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ImpalilaClinic.setOrganisationUnitCode("10108");
		ImpalilaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(ImpalilaClinic);
		
		OrganisationUnit IsizeClinic = new OrganisationUnit();
		IsizeClinic.setOrganisationUnitName("Isize Clinic");
		IsizeClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		IsizeClinic.setOrganisationUnitCode("10109");
		IsizeClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(IsizeClinic);

		OrganisationUnit ItombaClinic = new OrganisationUnit();
		ItombaClinic.setOrganisationUnitName("Itomba Clinic");
		ItombaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		ItombaClinic.setOrganisationUnitCode("10110");
		ItombaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(ItombaClinic);

		OrganisationUnit KabbeClinic = new OrganisationUnit();
		KabbeClinic.setOrganisationUnitName("Kabbe Clinic");
		KabbeClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KabbeClinic.setOrganisationUnitCode("10111");
		KabbeClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KabbeClinic);

		OrganisationUnit KanonoClinic = new OrganisationUnit();
		KanonoClinic.setOrganisationUnitName("Kanono Clinic");
		KanonoClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KanonoClinic.setOrganisationUnitCode("10112");
		KanonoClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KanonoClinic);

		OrganisationUnit KashesheClinic = new OrganisationUnit();
		KashesheClinic.setOrganisationUnitName("Kasheshe Clinic");
		KashesheClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KashesheClinic.setOrganisationUnitCode("10113");
		KashesheClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KashesheClinic);

		OrganisationUnit KatimaDistrictHospital = new OrganisationUnit();
		KatimaDistrictHospital.setOrganisationUnitName("Katima District Hospital");
		KatimaDistrictHospital.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaDistrictHospital.setOrganisationUnitCode("10114");
		KatimaDistrictHospital.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaDistrictHospital);

		OrganisationUnit KatimaMuliloClinic = new OrganisationUnit();
		KatimaMuliloClinic.setOrganisationUnitName("Katima Mulilo Clinic");
		KatimaMuliloClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaMuliloClinic.setOrganisationUnitCode("10115");
		KatimaMuliloClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaMuliloClinic);

		OrganisationUnit LinyantiClinic = new OrganisationUnit();
		LinyantiClinic.setOrganisationUnitName("Linyanti Clinic");
		LinyantiClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		LinyantiClinic.setOrganisationUnitCode("10116");
		LinyantiClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(LinyantiClinic);
		
		OrganisationUnit LisikiliClinic = new OrganisationUnit();
		LisikiliClinic.setOrganisationUnitName("Lisikili Clinic");
		LisikiliClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		LisikiliClinic.setOrganisationUnitCode("10117");
		LisikiliClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(LisikiliClinic);
				
		OrganisationUnit LuseseClinic = new OrganisationUnit();
		LuseseClinic.setOrganisationUnitName("Lusese Clinic");
		LuseseClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		LuseseClinic.setOrganisationUnitCode("10118");
		LuseseClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(LuseseClinic);

		OrganisationUnit MasokotwaneClinic = new OrganisationUnit();
		MasokotwaneClinic.setOrganisationUnitName("Masokotwane Clinic");
		MasokotwaneClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		MasokotwaneClinic.setOrganisationUnitCode("10119");
		MasokotwaneClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(MasokotwaneClinic);

		OrganisationUnit MavulumaClinic = new OrganisationUnit();
		MavulumaClinic.setOrganisationUnitName("Mavuluma Clinic");
		MavulumaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		MavulumaClinic.setOrganisationUnitCode("10120");
		MavulumaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(MavulumaClinic);

		OrganisationUnit MbalasinteClinic = new OrganisationUnit();
		MbalasinteClinic.setOrganisationUnitName("Mbalasinte Clinic");
		MbalasinteClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		MbalasinteClinic.setOrganisationUnitCode("10121");
		MbalasinteClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(MbalasinteClinic);

		OrganisationUnit MuyakoClinic = new OrganisationUnit();
		MuyakoClinic.setOrganisationUnitName("Muyako Clinic");
		MuyakoClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		MuyakoClinic.setOrganisationUnitCode("10122");
		MuyakoClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(MuyakoClinic);
		
		OrganisationUnit KatimaMuliloNAPPAYouthClinic = new OrganisationUnit();
		KatimaMuliloNAPPAYouthClinic.setOrganisationUnitName("Katima Mulilo NAPPA Youth Clinic");
		KatimaMuliloNAPPAYouthClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaMuliloNAPPAYouthClinic.setOrganisationUnitCode("10123");
		KatimaMuliloNAPPAYouthClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaMuliloNAPPAYouthClinic);
				
		OrganisationUnit NgomaClinic = new OrganisationUnit();
		NgomaClinic.setOrganisationUnitName("Ngoma Clinic");
		NgomaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		NgomaClinic.setOrganisationUnitCode("10124");
		NgomaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(NgomaClinic);

		OrganisationUnit NgwezeClinic = new OrganisationUnit();
		NgwezeClinic.setOrganisationUnitName("Ngoma Clinic");
		NgwezeClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		NgwezeClinic.setOrganisationUnitCode("10125");
		NgwezeClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(NgwezeClinic);

		OrganisationUnit NorthStarAllianceClinic = new OrganisationUnit();
		NorthStarAllianceClinic.setOrganisationUnitName("North Star Alliance Clinic");
		NorthStarAllianceClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		NorthStarAllianceClinic.setOrganisationUnitCode("10126");
		NorthStarAllianceClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(NorthStarAllianceClinic);

		OrganisationUnit SachonaClinic = new OrganisationUnit();
		SachonaClinic.setOrganisationUnitName("Sachona Clinic");
		SachonaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SachonaClinic.setOrganisationUnitCode("10127");
		SachonaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(SachonaClinic);

		OrganisationUnit SangwaliHealthCentre = new OrganisationUnit();
		SangwaliHealthCentre.setOrganisationUnitName("Sangwali Health Centre");
		SangwaliHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SangwaliHealthCentre.setOrganisationUnitCode("10128");
		SangwaliHealthCentre.setParent(KatimaMuliloDistrict);
		orgUnitList.add(SangwaliHealthCentre);

		OrganisationUnit SchuckmansburgClinic = new OrganisationUnit();
		SchuckmansburgClinic.setOrganisationUnitName("Schuckmansburg Clinic");
		SchuckmansburgClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SchuckmansburgClinic.setOrganisationUnitCode("10129");
		SchuckmansburgClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(SchuckmansburgClinic);
		
		OrganisationUnit SeshekeClinic = new OrganisationUnit();
		SeshekeClinic.setOrganisationUnitName("Sesheke Clinic");
		SeshekeClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SeshekeClinic.setOrganisationUnitCode("10130");
		SeshekeClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(SeshekeClinic);

		OrganisationUnit SibbindaHealthCentre = new OrganisationUnit();
		SibbindaHealthCentre.setOrganisationUnitName("Sibbinda Health Clinic");
		SibbindaHealthCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		SibbindaHealthCentre.setOrganisationUnitCode("10131");
		SibbindaHealthCentre.setParent(KatimaMuliloDistrict);
		orgUnitList.add(SibbindaHealthCentre);

		OrganisationUnit MafutaClinic = new OrganisationUnit();
		MafutaClinic.setOrganisationUnitName("Mafuta Clinic");
		MafutaClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		MafutaClinic.setOrganisationUnitCode("10132");
		MafutaClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(MafutaClinic);

		OrganisationUnit KatimaMuliloNRCS = new OrganisationUnit();
		KatimaMuliloNRCS.setOrganisationUnitName("Katima Mulilo NRCS");
		KatimaMuliloNRCS.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaMuliloNRCS.setOrganisationUnitCode("10547");
		KatimaMuliloNRCS.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaMuliloNRCS);

		OrganisationUnit KatimaMuliloWBCGClinic = new OrganisationUnit();
		KatimaMuliloWBCGClinic.setOrganisationUnitName("Katima Mulilo WBCG Clinic");
		KatimaMuliloWBCGClinic.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaMuliloWBCGClinic.setOrganisationUnitCode("10548");
		KatimaMuliloWBCGClinic.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaMuliloWBCGClinic);

		OrganisationUnit KatimaFamilyPractice = new OrganisationUnit();
		KatimaFamilyPractice.setOrganisationUnitName("Katima Family Practice");
		KatimaFamilyPractice.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaFamilyPractice.setOrganisationUnitCode("10627");
		KatimaFamilyPractice.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaFamilyPractice);

		OrganisationUnit RiversideMedicalCentre = new OrganisationUnit();
		RiversideMedicalCentre.setOrganisationUnitName("Riverside Medical Centre");
		RiversideMedicalCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		RiversideMedicalCentre.setOrganisationUnitCode("10631");
		RiversideMedicalCentre.setParent(KatimaMuliloDistrict);
		orgUnitList.add(RiversideMedicalCentre);

		OrganisationUnit KatimaMedicalCentre = new OrganisationUnit();
		KatimaMedicalCentre.setOrganisationUnitName("Katima Medical Centre");
		KatimaMedicalCentre.setOrganisationUnitLevel(new OrganisationUnitLevel(4));
		KatimaMedicalCentre.setOrganisationUnitCode("10632");
		KatimaMedicalCentre.setParent(KatimaMuliloDistrict);
		orgUnitList.add(KatimaMedicalCentre);
		
		return orgUnitList;
	}
	
	public static List<ServiceType> generateServiceTypes(){
		
		List<ServiceType> serviceTypes = new ArrayList<ServiceType>();
		ServiceType antenatal = new ServiceType();
		antenatal.setName("Antenatal");
		serviceTypes.add(antenatal);
		ServiceType fp = new ServiceType();
		fp.setName("Family Planning");
		serviceTypes.add(fp);
		ServiceType cp = new ServiceType();
		cp.setName("Condom promotion and distribution");
		serviceTypes.add(cp);
		
		return serviceTypes;
		
	}
	public static List<OrganisationUnitLevel> generateOrgUnitLevels(){
		List<OrganisationUnitLevel> orgUnitLevels = new ArrayList<OrganisationUnitLevel>();
		OrganisationUnitLevel national = new OrganisationUnitLevel();
		national.setLevel(1);
		national.setName("National");
		national.setUuid(UUID.randomUUID().toString());
		orgUnitLevels.add(national);
		
		OrganisationUnitLevel regional = new OrganisationUnitLevel();
		regional.setLevel(2);
		regional.setName("Regional");
		regional.setUuid(UUID.randomUUID().toString());
		orgUnitLevels.add(regional);
		
		OrganisationUnitLevel district = new OrganisationUnitLevel();
		district.setLevel(3);
		district.setName("District");
		district.setUuid(UUID.randomUUID().toString());
		orgUnitLevels.add(district);
		
		OrganisationUnitLevel facility = new OrganisationUnitLevel();
		facility.setLevel(4);
		facility.setName("Facility");
		facility.setUuid(UUID.randomUUID().toString());
		orgUnitLevels.add(facility);
		return orgUnitLevels;
	}
	public static List<OrganisationUnitOwner> getOrgUnitOwners(){
		List<OrganisationUnitOwner> owners = new ArrayList<OrganisationUnitOwner>();
		OrganisationUnitOwner mohss = new OrganisationUnitOwner();
		mohss.setOwnerName("MOHSS");
		owners.add(mohss);
		OrganisationUnitOwner privateOwner = new OrganisationUnitOwner();
		privateOwner.setOwnerName("PRIVATE");
		owners.add(privateOwner);
		return owners;
	}
}
