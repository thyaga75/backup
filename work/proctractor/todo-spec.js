// Use the external Chai As Promised to deal with resolving promises in
// expectations.
var chai = require('chai');
var chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
var expect = chai.expect;

// Chai's expect().to.exist style makes default jshint unhappy.
// jshint expr:true

describe('protractor library', function() {
	this.timeout(15000);
  it('should wrap webdriver', function() {
    // Mocha will report the spec as slow if it goes over this time in ms.
    browser.driver.manage().window().maximize();
    browser.driver.get('http://cricket.yahoo.com');
   // this.timeout(30000);
   // var EC = protractor.ExpectedConditions;
    //browser.driver.findElement(by.name('p')).sendKeys('testing');
    //this.timeout(5000);
    browser.driver.findElement(by.css('.yom-list li:nth-child(1)')).click().then(function(){
    	console.log('Click worked');
    //	browser.driver.sleep(5000);
    });
	
	});

 });