# Custom TestNG Report 
--- 
## [Demo](https://rawgit.com/cushychandru/TestNG-Report/master/Report%20Example/Report/Report.html)



# Features

- User friendly result.
- Show Passed, failed and skiped test cases % vise and shows count.
- Time taken per test exicution.
- Failed test cases analysation.
- Responve grafical representation.
- Sorting and searching test cases.
- anable and desable auto refresh.
- See test result while test Suite running.
- Auto priew of result in your defalut browser.
- Faild test Suite genateror.
- Auto backup your old report.
- Compatible with all major browsers (IE8+).

# Getting Started


#### Download Sources [Here](https://github.com/cushychandru/TestNG-Report/zipball/master)

#### OR use git

```bash
git clone https://github.com/cushychandru/TestNG-Report.git
```
- Go to souce folder and get jar
- Add Jar into TestNg project
- take properties file from source folder and customize as per your need the put properties file into class path
- Add Listener to testNG suit file ( Examole suite file available in source folder)
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd"> 
<suite name="selenium_suit" verbose="10">
	<listeners>
		<listener class-name="report_genarator.Listener"/>
	</listeners>
	<test name="selenium_test" preserve-order="true"> 
		<classes>
		<class name="TestReport.Test2"/>
		<class name="TestReport.Test2"/>
    </classes>
	</test>
</suite>
```
in this this part is must
```xml 
<listeners>
   	<listener class-name="report_genarator.Listener"/>
 </listeners>
 ```
- Change your default html preview browser ( don't select testing browser )
