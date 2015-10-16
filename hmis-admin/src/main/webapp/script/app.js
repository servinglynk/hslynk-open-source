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
        
        .segment('s1', {
            templateUrl: 'templates/login.html'})
        
        .segment('s2', {
            templateUrl: 'templates/root.html'})
		 .within()
		
         .segment('dashborad', {
                templateUrl: 'templates/partial/dashborad.html'})   
		  .segment('managefiles', {
                templateUrl: 'templates/partial/managefiles.html', controller: 'managefilesCtrl'})   
		  .segment('bulkupload', {
                templateUrl: 'templates/partial/bulkupload.html'})   
		  .segment('managesync', {
                templateUrl: 'templates/partial/managesync.html'})   
        .up()
        
    $routeProvider.otherwise({redirectTo: '/login'});  // default redirect
}) ;

app.value('loader', {show: false});
