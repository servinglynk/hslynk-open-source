var app = angular.module('app', ['ngRoute', 'ngAnimate', 'route-segment', 'view-segment','ui.bootstrap']);

app.config(function($routeSegmentProvider, $routeProvider) {
    
    // Configuring provider options
    
    $routeSegmentProvider.options.autoLoadTemplates = true;
    
    // Setting routes. This consists of two parts:
    // 1. `when` is similar to vanilla $route `when` but takes segment name instead of params hash
    // 2. traversing through segment tree to set it up
  
    $routeSegmentProvider
    
        .when('/login',          's1') // this is for login
        .when('/admin',          's2.dashborad')
        .when('/admin/dashborad',      's2.dashborad')
		 .when('/admin/managefiles',      's2.managefiles')
		  .when('/admin/bulkupload',      's2.bulkupload')
		   .when('/admin/managesync',      's2.managesync')
		      .when('/admin/managereport',      's2.managereport')
       		  .when('/admin/setting',      's2.setting')
			   .when('/admin/requestreport',      's2.requestreport')
        .segment('s1', {
            templateUrl: 'templates/login.html'})
        
        .segment('s2', {
            templateUrl: 'templates/root.html'})
		 .within()
		
         .segment('dashborad', {
                templateUrl: 'templates/partial/dashborad.html', controller: 'dashboradCtrl'})   
		  .segment('managefiles', {
                templateUrl: 'templates/partial/managefiles.html', controller: 'managefilesCtrl'})   
		   .segment('managereport', {
                templateUrl: 'templates/partial/managereport.html', controller: 'managereportCtrl'})   
		  .segment('bulkupload', {
		      templateUrl: 'templates/partial/bulkupload.html', controller: 'bulkUploadCtrl'})   
		  .segment('managesync', {
                templateUrl: 'templates/partial/managesync.html', controller: 'managesyncCtrl'})   
		    .segment('setting', {
                templateUrl: 'templates/partial/setting.html', controller: 'settingCtrl'})   
			 .segment('requestreport', {
                templateUrl: 'templates/partial/requestreport.html', controller: 'requestreportCtrl'})   
        .up()
        
    $routeProvider.otherwise({redirectTo: '/login'});  // default redirect
}) ;

app.value('loader', { show: false });

app.directive('appFilereader', function ($q) {
    var slice = Array.prototype.slice;
		
    return {
        restrict: 'A',
        require: '?ngModel',
        link: function (scope, element, attrs, ngModel) {
            if (!ngModel) return;

            ngModel.$render = function () { };

            element.bind('change', function (e) {
									
                var element = e.target;
                ngModel.$setViewValue(element);
            }); 

        } //link
    }; //return
});
