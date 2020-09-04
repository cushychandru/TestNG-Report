package com.testng_reporter.demo.constant;

import org.openqa.selenium.By;

/**
 * <b>The Class Xpath.</b><br>
 * X-Path of all element with module wise <br>
 * To make easy to debug and development
 * 
 * @author Chandrashekhar Gouda
 * @version 1.0
 * @since 2018-10-22
 */
public class Xpath {

	public static class LogIn {

		public static By USER_NAME = By.id("inputEmail");

		public static By PASS_WORD = By.id("inputPassword");

		public static By SIGN_IN = By.xpath("//button[@type='submit']");
	}

	public static class NavBar {

		public static String DROP_DOWNS_MENUS = "/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li";

	}

	public static class Title {

		public static String TITLE = "//label[@class='col-sm-12 col-form-label text-center page-header']";
	}

	public static class Customer {

		public static class search {

			public static By TITLE = By.xpath("//label[contains(@class,'col-sm-12 col-form-label text-center page-header')]");

			public static By CUSTOMER_NAME = By.name("Ico1CustomerName");

			public static By IC01_IDENTIFIER = By.name("Ico1Identifier");

			public static By ONLY_BY_SPECIFIC_IC_01_SUPPORTED = By.name("specificIco1Supported");

			public static By PER_PAGE = By.id("select9");

			public static By SEARCH = By.xpath("//a[contains(@class,'btn btn-primary')][contains(text(),'Search')]");

			public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

			public static By BACK = By.xpath("//a[contains(text(),'Back')]");

		}

		public static class search_result {

			public static By TITLE = By.xpath("//label[contains(@class,'col-sm-12 col-form-label text-center page-header')]");

			public static By PAGINATION = By.xpath("//div[@class='container-fluid']//div[2]//div[1]//div[1]//div[1]//div[1]//a");

			public static String TABLE = "//table[@class='table table-bordered']";
		}

		public static class edit {

			public static By TITLE = By.xpath("//label[contains(@class,'col-sm-12 col-form-label text-center page-header')]");

			public static By CUSTOMER_IC_01_NAMES = By.id("lstCustNames");

			public static By CUSTOMER_ALIAS = By.name("customerAlias");

			public static By PRIMARY_CUSTOMER_CAC_NAME = By.id("select1");

			public static By END_USER_CAC_NAME = By.id("select2");

			public static By CUSTOMER_SEGMENTATION_LEVEL = By.xpath("//div[contains(text(),'Strategic Account: Global - Diamond')]");

			public static By PARTNER_CHANNEL = By.id("partnerchannel");

			public static By CSM_GRP_MAIL = By.id("csmgrpmail");

			public static By CONTRACT_END_DATE = By.id("newCal");

			public static By SOLD_FTE_CUSTOMER_SERVICES = By.name("servManCommittedD");

			public static By SOLD_FTE_CHANGE_REL_MAN = By.name("changeRelManCommitted");

			public static By SOLD_FTE_OTHERS = By.name("othersCommitted");

			public static By FTE_Allocated_CUSTOMER_SERVICES = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[11]/div[1]/input[1]");

			public static By FTE_Allocated_CHANGE_REL_MAN = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[11]/div[2]/input[1]");

			public static By FTE_Allocated_OTHERS = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[11]/div[3]/input[1]");

			public static By LINK_RESOURCE = By.xpath("//button[contains(text(),'Link resource')]");

			public static By APPLY = By.xpath("//button[contains(text(),'Apply')]");

			public static By BACK = By.xpath("//a[contains(text(),'Back')]");

			public static String RESOURCE_ASSIGNED_TABLE = "//table[@id='sortTable1']";

		}
	}

	public static class Resource {

		public static class Search {

			public static By FIRST_NAME = By.name("firstName");

			public static By LAST_NAME = By.name("lastName");

			public static By WORKGROUP_NAME = By.id("wrkGroupId");

			public static By ADV_SEARCH = By.xpath("//a[contains(text(),'Advanced Search')]");

			public static By NO_PAGES = By.id("select9");

			public static By SEARCH = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Search')]");

			public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

			public static By BACK = By.xpath("//a[contains(text(),'Back')]");

			public static By RESOURCETYPE = By.name("csmType");

			public static By REGION = By.name("region");

			public static By SUBREGION = By.id("select3");

			public static By COUNTRY = By.id("select4");

		}

		public static class SearchResult {

			public static By TITLE = By.xpath("//label[contains(@class,'col-sm-12 col-form-label text-center page-header')]");

			public static String TABLE = "//table[@class='table table-bordered']//tbody";

			public static String TABLE_TD = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr/td";

			public static By PAGINATION = By.xpath("//div[@class='container-fluid']//div[2]//div[1]//div[1]//div[1]//a");

			public static String LINK_TABLE = "/html[1]/body[1]/div[1]/form[1]/div[9]/table[1]/tbody";

		}

		public static class View_Edit {

			public static By RESOURCE_NAME = By.id("empName");

			public static By FTID = By.id("ftid");

			public static By REGION = By.name("region");

			public static By SUBREGION = By.name("subRegion");

			public static By COUNTRY = By.name("country");

			public static By CITYSEARCH = By.xpath("//a[@class='btn btn-primary btn-sm']");

			public static By HEADCOUNT = By.name("headCount");

			public static By MOBILE = By.name("mobile");

			public static By PHONE = By.name("phone");

			public static By EMAIL = By.name("email");

			public static String RESOURCE_TYPE = "/html[1]/body[1]/div[1]/form[1]/div[12]/div[1]/div";

			public static By TEAMLEAD = By.name("teamLead");

			public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

			public static By LINK_CUSTOMER = By.xpath("//a[contains(text(),'Link customer')]");

			public static By BACK = By.xpath("//a[contains(text(),'Back')]");

			public static By TITLE = By.xpath("//label[@class='col-sm-12 col-form-label text-center page-header']");

			public static By CITY = By.name("external_city");

			public static By CITY_SEARCH = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Search')]");

			public static String CITY_TABLE = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]";

			public static By WORKGROUP_NAME = By.id("workgrpName");

			public static By CSD_REGION = By.id("region");

			public static By CSD_SUBREGION = By.id("subregion");

			public static By CSD_CITY = By.xpath("//form[@name='editCSD']//div[6]//div[1]//input[1]");

			public static By CSD_COUNTRY = By.id("country");

			public static By CSD_SUPERVISOR = By.id("supervisor");

			public static By CSD_FUNCTIONALAREA = By.id("functional_area");

			public static String RESOURCE_ASIGN_TABLE = "//table[@id='sortTable2']";

			public static String CUSTOMER_SUPPORTED = "//table[@id='sortTable1']/tbody/tr";

			public static String CUSTOMER_SUPPORTED_SDESK = "//table[@id='sortTable1']/tbody/tr";

		}

		public static class DeleteResource {

			public static By ERROR_MSGBLOCK = By.xpath("html/body/div/div");
		}

	}

	public static class Calender {

		public static By ICON = By.xpath("//img[@src='/images/cal.gif']");

		public static By ICON_1 = By.xpath("//img[@src='images/cal.gif'][1]");

		public static By TODAY = By.xpath("//font[@class='calR']");

		public static By MONTH = By.name("MonthSelector");

		public static By YEAR = By.name("YearSelector");

		public static String Dates = "//span//tbody//tbody//tr";
	}

	public static class Linking {

		public static By TITLE = By.xpath("//label[contains(@class,'col-sm-12 col-form-label text-center page-header')]");

		public static By RESOURCE_NAME = By.id("select3");

		public static By PRIMARY_CUSTOMER_CAC_NAME = By.id("select1");

		public static By END_USER_CAC_NAME = By.id("endCacNameId");

		public static By PL_Customers = By.id("select0008");

		public static By PL_Customers_Disable = By.id("select1");

		public static By Selected_PL_Customers = By.id("select0009");

		public static By Oceane_Eds = By.id("oceane");

		public static By IC01_CUSTOMER_NAMES = By.id("select007");

		public static By SUPPORT_OFFER = By.id("supportoffer");

		public static By SELECTED_IC01_CUSTOMER_NAMES = By.id("select008");

		public static By BACK_UP_RESOURCE = By.id("select23");

		public static By BACK_UP_SEARCH = By.id("backup_href");

		public static By SITES_SUPERVISED_NETWORK = By.name("SITES_NETWORK");

		public static By SITES_SUPERVISED_IS = By.name("SITES_IS");

		public static By SITES_SUPERVISED_TELEPHONY = By.name("SITES_TELEPHONY");

		public static By SITES_SUPERVISED_TELEPRESENCE = By.name("SITES_TELEPRESENCE");

		public static By CONNECTIONS_SUPERVISED_NETWORK = By.name("CONNECTIONS_NETWORK");

		public static By CONNECTIONS_SUPERVISED_IS = By.name("CONNECTIONS_IS");

		public static By CONNECTIONS_SUPERVISED_TELEPHONY = By.name("CONNECTIONS_TELEPHONY");

		public static By CONNECTIONS_SUPERVISED_TELEPRESENCE = By.name("CONNECTIONS_TELEPRESENCE");

		public static By RESOURCE_START_DATE = By.id("selectNewCal");

		public static By FTE_ALLOCATION = By.name("fteAllocation");

		public static By PRODUCT_SERVICE = By.id("select7");

		public static By SUPPORTED_PRODUCT_SERVICE = By.id("select8");

		public static By SUPPORTED_COUNTRY = By.id("select9");

		public static By RESOURCE_TYPE = By.id("select12");

		public static By SUPPORTED_REGION = By.id("id_select_supportedRegion");

		public static By RESOURCE_UTILIZATION_TYPE = By.id("select10");

		public static By LEAD_RESOURCE = By.name("leadCSM");

		public static By PRIME_TECHNICAL_ENGINEER = By.id("select22");

		public static By COMMUNITY_DOMAIN = By.name("cmmDomain");

		public static By CONTRACT_SIGNED_REGION = By.name("regionContractSigned");

		public static By SUPPORT_PROVIDING = By.name("supportProvidedByResource");

		public static By HISTORY = By.id("historytextarea");

		public static By LINK_EXIST = By.xpath("//font[@color='#FF0000']");

		public static By COMMENT = By.name("comment");

		public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");;

		public static By BACK = By.xpath("//a[@class='btn btn-primary btn-md']");

		public static class SDesk {

			public static By RESOURCE_TYPE = By.id("selectCsd");

			public static By INCIDENT_MGT = By.name("incidentMgt");

			public static By PERFORMANCE_MGT = By.name("performanceMgt");

			public static By BEFORE_LANGUAGES_SUPPORTED = By.name("beforelanguagesSupported");

			public static By LANGUAGES_SUPPORTED = By.name("languagesSupported");

		}

		public static class CustomerToResource {

			public static By CUSTOMER_SEARCH = By.xpath("//form[@id='linkUser_form']//div[4]//div[2]//a[1]");

			public static By RESOURCE_SEARCH = By.xpath("//form[@id='linkUser_form']//div[5]//div[2]//a[1]");

		}

		public static class ResourceToCustomer {

			public static By CUSTOMER_SEARCH = By.xpath("//form[@id='linkUser_form']//div[5]//div[2]//a[1]");

			public static By RESOURCE_SEARCH = By.xpath("//form[@id='linkUser_form']//div[3]//div[2]//a[1]");

		}

		public static class EditResourceCustomer {

			public static By RESOURCE_SEARCH = By.id("editSearch_href");

		}

		public static class EditCustomerResource {

			public static By RESOURCE_SEARCH = By.id("editSearch_href");

		}

	}

	public static class Maintainance {

		public static class FileUpload {

			public static class SDesk {

				public static By RESOURCE_TYPE = By.id("selectCsd");

				public static By INCIDENT_MGT = By.name("incidentMgt");

				public static By PERFORMANCE_MGT = By.name("performanceMgt");

				public static By BEFORE_LANGUAGES_SUPPORTED = By.name("beforelanguagesSupported");

				public static By LANGUAGES_SUPPORTED = By.name("languagesSupported");

				public static By INPUT_FILE = By.id("excelFileid");

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

			}

			public static class About {

				public static By INPUT_FILE = By.id("excelFileid");

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");
			}

			public static class Assignment {

				public static By ASSIGNMENT_TYPE = By.id("rType");

				public static By INPUT_FILE = By.id("excelFileid");

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

			}

			public static class CACFile {

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By INPUT_FILE = By.id("excelFileid");

			}

			public static class Helpdocumentaion {

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By INPUT_FILE = By.id("excelFileid");

			}

			public static class Servicedesk {

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By INPUT_FILE = By.id("excelFileid");

			}

			public static class Oceane {

				public static By SUBMIT = By.xpath("//a[contains(text(),'Upload file')]");

				public static By INPUT_FILE = By.id("excelFileid");

			}
		}

		public static class Report {

			public static class Resource {

				public static By RESOURCE_ASSIGNMENT_LIST = By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[1]");

				public static By RESOURCE_PROGRESSBAR = By.id("progress");

				public static By ERROR = By.className("alert-warning");
			}

			public static class Sdesk {

				public static By SDESK_ASSIGNMENT_LIST = By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[2]");

				public static By SDESK_PROGRESSBAR = By.id("progress");

				public static By ERROR = By.className("alert-warning");
			}

			public static class AssignmentHistory {

				public static By ASSIGNMENT_HISTORY_LIST = By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[3]");

				public static By ASSIGNMENT_TYPE = By.id("assignmentTypeId");

				public static By HISTORY_PROGRESSBAR = By.id("progress");

				public static By ERROR = By.className("alert-warning");

				public static By APPLY = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[4]/div[1]/a[1]");

				public static By POPUP_OK = By.xpath("/html[1]/body[1]/div[3]/div[4]/input[1]");

				public static By FROM_CALENDER = By.id("FromCalender");

				public static By TO_CALENDER = By.id("storedToDateId");

			}

			public static class Customized {

				public static String ASSIGNMENT_TYPE = "//div[@class='form-group row form-group-sm']//div[@class='col-sm-6']//div";

				public static String SDESK_ASSIGNMENT_SOURCE = "//div[@class='form-group row']//div[@class='col-sm-6']/div";

				public static String SDESK_TYPE = "/html[1]/body[1]/div[1]/form[1]/div[2]/div[1]/div";

				public static String RESOURCE = "//div[@id='resourceTab']/div";

				public static String RESOURCE_SDESK = "//div[@id='resourceTab']/div";

				public static String CUSTOMER = "//div[@id='customerTab']/div";

				public static String CUSTOMER_SDESK = "//div[@id='customerTab']/div";

				public static String ASSIGNMENT = "//div[@id='assignmentTab']/div";

				public static String ASSIGNMENT_SDESK = "//div[@id='assignmentTab']/div";

				public static String SUPERVISION = "//div[@id='supervisionTab']/div";

				public static String SUPERVISION_SDESK = "//div[@id='supervisionTab']/div";

				public static By FILTERCRITERIATITLE = By.xpath("/html[1]/body[1]/div[5]/label[2]");

				public static By EDITFILTER = By.xpath("//button[contains(text(),'Edit filter')]");

				public static By SELECTOR_COLUMN1 = By.id("filterColumn");

				public static By SELECTOR_COLUMN1_SDESK = By.id("filterColumn");

				public static By SELECTOR_COLUMN2 = By.id("filterOperator");

				public static By SELECTOR_COLUMN2_OPTION = By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/select[1]/option");

				public static By SELECTOR_COLUMN2_SDESK = By.id("filterOperator");

				public static By SELECTOR_COLUMN3 = By.id("filterTextField");

				public static By SELECTOR_COLUMN3_SDESK = By.id("filterTextField");

				public static By DATA_LIST_INPUT = By.id("filterTextField");

				public static By DATA_LIST_INPUT_TYPE = By.id("filterDropDown");

				public static By ADD_TO_FILTER = By.id("andButtonImg");

				public static By ADD_TO_FILTER_AND_SDESK = By.id("andButtonImg");

				public static By ADD_TO_FILTER_OR_SDESK = By.id("orButton");

				public static By DISPLAY_FILTER_TABLE = By.id("filterTableBody");

				public static By DELETE = By.xpath("//table[@id='filterTableBody']//tbody//tr//td//img");

				public static By DELETE_SDESK = By.xpath("//table[@id='filterTableBody']//tbody//tr//td//img");

				public static By CLEAR_BUTTON = By.id("clearFilterB");

				public static By CLEAR_BUTTON_SDESK = By.id("clearFilterB");

				public static By DISPLAY_EDIT_FILTER_TABLE = By.id("selectedFiltersDiv");

				public static By OK = By.id("OkB");

				public static By OK_SDESK = By.id("OkB");

				public static By OK_BUTTON_FILTER = By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]");

				public static By DOWNNLOAD_BUTTON = By.xpath("//a[contains(text(),'Download')]");

				public static By DOWNNLOAD_BUTTON_SDESK = By.xpath("//a[contains(text(),'Download')]");

				public static By PROGRESS_BAR = By.id("progress");

				public static By LOAD_IMAGE = By.id("ajaxLoadImageDiv");

				public static By DOWNLOAD_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[1]");
			}

			public static class HeadCount {

				public static By HEAD_COUNT = By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[5]");

				public static By HEAD_COUNT_PROGRESSBAR = By.id("progress");

				public static By ERROR = By.className("alert-warning");
			}
		}

		public static class Advance_Business_Report {

			public static By MANAGE_ADVANCE_REPORT = By.id("manageadvid");

			public static By ADD_BUTTON = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/a[1]");

			public static By SHARE_POINT_LINK_NAME = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[2]/div[1]/input[1]");

			public static By SHARE_POINT_LINK_URL = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[3]/div[1]/input[1]");

			public static By APPLY_BUTTON = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[5]/div[1]/a[1]");

			public static By CLEAR_BUTTON = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[5]/div[1]/a[2]");

			public static By OK_BUTTON = By.id("popup_close_alert");

			public static By SAVE_OK_BUTTON = By.xpath("/html[1]/body[1]/div[3]/div[4]/input[1]");

			public static By VIEW_EDIT = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]");
		}

		public static class ManagementTask {

			public static class ContentMgmt {

				public static By MSGBLOCK = By.xpath("//*[@id='myInstance']");

				public static By SAVE = By.xpath("//*[@id='myNicPanel']/div/div/div[1]/div/div/div");

				public static By PRE_VIEW = By.xpath("//*[@id='preivew']");

				public static By PRE_VIEW_CONTENT = By.xpath("//div[@class='container-fluid']");

			}

			public static class ContryCostTierLang {

				public static By COUNTRY = By.id("country");

				public static By COSTTIER = By.id("costtier");

				public static By LEFTLANG = By.name("beforelanguagesSupported");

				public static By RIGHTLANG = By.name("languagesSupported");

				public static By HISTORY = By.id("historytextarea");

				public static By UPDATE = By.xpath("//a[contains(text(),'Update')]");
				
				public static By LANGUAGE = By.xpath("//select[@id='select13']");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String LISTOPTION = "/html[1]/body[1]/div[1]/form[1]/div[4]/div[4]/select[1]";

			}

			public static class LanguageSupport {

				public static By ADD = By.xpath("//a[@class='btn btn-primary btn-md' and contains(text(),'Add')]");

				public static By DUPLICATEADD = By.xpath("//div[@class='alert alert-warning text-center index-align-middle']");

				public static By LANGUAGEFIELD = By.name("languageName");

				public static String TABLE = "//table[@name='Languages']/tbody";

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String PAGINATION = "//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]/a";
			}

			public static class ProductService {

				public static By ADD = By.xpath("//a[@class='btn btn-primary btn-md' and contains(text(),'Add')]");

				public static By DUPLICATEADD = By.xpath("//div[@class='alert alert-warning text-center index-align-middle']");

				public static By PRODUCTSERVICEFIELD = By.name("productName");

				public static By PRODUCTDESCEFIELD = By.name("productDesc");

				public static String TABLE = "//table[@id='sortTable1']/tbody";

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String PAGINATION = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a";
			}

			public static class ResourceType {

				public static By ADD = By.xpath("//a[@class='btn btn-primary btn-md' and contains(text(),'Add')]");

				public static By DUPLICATEADD = By.xpath("//div[@class='alert alert-warning text-center index-align-middle']");

				public static By RESOURCETYPEFIELD = By.name("resourceType");

				public static By RESOURCETYPEDESCFIELD = By.name("resourceTypeDescription");

				public static By FTETYPEIDFIELD = By.name("fteTypeID");

				public static String TABLE = "//table[@id='sortTable1']/tbody";

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String PAGINATION = "//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//a";
			}

			public static class ResourceUtilType {

				public static By ADD = By.xpath("//a[@class='btn btn-primary btn-md' and contains(text(),'Add')]");

				public static By DUPLICATEADD = By.xpath("//div[@class='alert alert-warning text-center index-align-middle']");

				public static By RESOURCEUTILTYPEFIELD = By.name("resourceUtilizationTypeDesc");

				public static String TABLE = "//table[@id='sortTable1']/tbody";

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String PAGINATION = "//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//a";
			}

			public static class AdvanceReport {

				public static By ADD = By.xpath("//a[@class='btn btn-primary btn-md' and contains(text(),'Add')]");

				public static By DUPLICATEADD = By.xpath("//div[@class='alert alert-warning text-center index-align-middle']");

				public static By ADVANCEREPORTFIELD = By.name("spLinkName");

				public static By ADVANCEREPORTURLFIELD = By.name("spLinkUrl");

				public static String TABLE = "//table[@id='sortTable1']/tbody";

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");

				public static String PAGINATION = "//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]/a";
			}

			public static class SdeskSearch {

				public static By SDESK_RES_LAST_NAME = By.name("csdLastName");

				public static By SDESK_RES_FIRST_NAME = By.name("csdFirstName");

				public static By WORKGROUP_NAME = By.name("csdWorkgroupName");

				public static By NO_PAGES = By.id("select9");

				public static By SEARCH = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Search')]");

				public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");
			}

			public static class SdeskSearchResult {

				public static String TABLE = "//table[@class='table table-bordered']/tbody[1]";

				public static String TABLE_TD = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr/td";

				public static By PAGINATION = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a");

				public static By BACK = By.xpath("//a[contains(text(),'Back')]");
			}

			public static class View_Edit {

				public static By SDESK_NAME = By.id("workgrpName");

				public static By REGION = By.id("region");

				public static By SUBREGION = By.id("subregion");

				public static By COUNTRY = By.id("country");

				public static By CITY = By.xpath("//div[6]//div[1]//input[1]");

				public static By SUPERVISOR = By.id("supervisor");

				public static By FUNCTIONALAREA = By.id("functional_area");

				public static String TABLE = "//table[@id='sortTable1']/tbody";

			}

			public static class Manage_User_List {

				public static By ROLE = By.id("roleSelect");

				public static By ROLE_SEARCH = By.xpath("//input[@class='form-control form-control-sm']");

				public static By TABLE_EDIT = By.xpath("//tr[1]//td[4]//a[1]//span[1]");

				public static By RESOURCE_DELETE = By.xpath("//tr[1]//td[4]//a[1]//span[1]");

				public static By LEFT_ROLES_LIST = By.xpath("//select[@id='leftSelectbox']");

				public static By RIGHT_ROLES_LIST = By.xpath("//select[@id='rightMultiSelect']");

				public static String RIGHT_ROLES_LIST_string = "//select[@id='rightMultiSelect']";

				public static By ADD_ROLE = By.xpath("//button[@id='addRoleId']");

				public static By REMOVE_ROLE = By.xpath("//button[@id='removeRoleId']");

				public static By RESOURCE_ALREADY_REGISTERED = By.xpath("//strong[contains(text(),'*Resource already registered')]");

				public static By MANAGE_REMOVE = By.id("RemoveButtonId");

				public static By APPLY_BUTTON = By.xpath("//a[contains(text(),'Apply')]");

				public static By MANAGE_USER_SEARCH = By.xpath("//input[@class='form-control form-control-sm']");
			}

			public static class Register_Resource {

				public static By GET_INFO = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[2]/div[1]/div[2]/a[1]");

				public static By FTID = By.id("ftidTextbox");

				public static By LEFT_ROLES_LIST = By.xpath("//select[@id='leftSelectbox']");

				public static By RIGHT_ROLES_LIST = By.cssSelector("#rightMultiSelect");

				public static By REGION = By.id("select2");

				public static By SUB_REGION = By.id("select3");

				public static By COUNTRY = By.id("select4");

				public static By SEARCH = By.id("citySearchButton");

				public static By CITY_NAME = By.xpath("//input[@name='external_city']");

				public static By SEARCH_CITY = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Search')]");

				public static By CITY = By.xpath("//a[@class='text-info']");

				public static String RESOURCE_TYPE = "/html[1]/body[1]/div[1]/form[1]/div[11]/div[1]/div";

				public static By HEADCOUNT = By.id("HeadCountID");

				public static By REGISTER_APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By TEAMLEADER = By.xpath("//select[@id='select7']");
			}

			public static class TestUserManagement {

				public static By USERNAME = By.id("username1");

				public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

				public static By NEW_ROLE = By.id("roleSelect");

				public static By MANAGER_ITEMS = By.xpath("/html[1]/body[1]/form[1]/nav[1]/div[1]/div[1]/ul[1]/li/a[1]");

				public static By MAINTAINANCE_MENU = By.xpath("//a[contains(text(),'Maintainance')]");
			}

			public static class Maintainace_Report {

				public static class Action_Tracker {

					public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

					public static By CLEAR = By.xpath("//a[contains(text(),'Clear')]");

					public static By ACTION_PROGRESSBAR = By.id("progress");

					public static By ERROR = By.className("alert-warning");

				}

				public static class AssignmentHistory {

					public static By ASSIGNMENTTYPE = By.id("assignmentTypeId");

					public static By HISTORYTYPE = By.id("historyId");

					public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

					public static By HISTORY_PROGRESSBAR = By.id("progress");

					public static By ERROR = By.className("alert-warning");

				}

				public static class ScheduledJob {

					public static By APPLY = By.xpath("//a[contains(text(),'Apply')]");

					public static By Scheduled_PROGRESSBAR = By.id("progress");

					public static By ERROR = By.className("alert-warning");

					public static By FREQUENCY = By.id("select2");
				}
			}

			public static class SchedulerReport {

				public static class COREscheduler {

					public static By START = By.xpath("//button[contains(text(),'Start')]");

					public static By STOP = By.xpath("//button[contains(text(),'Stop')]");

					public static By FREQUENCY = By.id("select2");
				}

				public static class OTLscheduler {

					public static By START = By.xpath("//button[contains(text(),'Start')]");

					public static By STOP = By.xpath("//button[contains(text(),'Stop')]");

					public static By FREQUENCY = By.id("select2");
				}

				public static class SmartAcess {

					public static By START = By.xpath("//button[contains(text(),'Start')]");

					public static By STOP = By.xpath("//button[contains(text(),'Stop')]");

				}

			}

			public static class FileUpload {

				public static By FILECHOSEN = By.id("excelFileid");

			}
		}

	}

	public static class RegionalContacts {

		public static String TABLE = "//table[@id='RegionalSpocTable']";

		public static By SEARCH = By.xpath("//input[@class='form-control form-control-sm']");

		public static By EDIT = By.id("Edit");

		public static By DELETE = By.id("delete");

		public static By UPDATE = By.id("update");

		public static By CANCEL = By.id("cancel");

		public static By SAVE = By.id("save");

		public static By REMOVE = By.id("remove");

		public static By ADD = By.id("add_row");

		public static By REGION = By.name("region");

		public static By SPOC = By.name("spoc");

		public static By TELEPHONE = By.name("telephone");

		public static By EMAIL = By.name("email");

		public static By COUNTRY = By.name("country");
	}

}
