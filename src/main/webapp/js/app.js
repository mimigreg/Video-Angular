var app = angular.module('video', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/films', {templateUrl: 'partials/films-list.html',   controller: FilmListCtrl}).
      when('/films/:filmId', {templateUrl: 'partials/films-detail.html', controller: FilmDetailCtrl}).
      when('/films/edit/:filmId', {templateUrl: 'partials/films-edit.html', controller: FilmEditCtrl}).
      when('/acteurs', {templateUrl: 'partials/acteurs-list.html',   controller: ActeurListCtrl}).
      when('/acteurs/:acteurId', {templateUrl: 'partials/acteurs-detail.html',   controller: ActeurDetailCtrl}).
      when('/acteurs/edit/:acteurId', {templateUrl: 'partials/acteurs-edit.html',   controller: ActeurEditCtrl}).
      otherwise({redirectTo: '/films'});
}]).filter('escape', function() {
	  return function(input) {
		    return escape(input);
	  };
});