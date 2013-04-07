function FilmListCtrl($scope, $http,$location) {
	$scope.query = '';
	$(".nav .active").removeClass("active");
	$("#navigationFilms").addClass("active");
	$http.get('services/film/all').success(function(data) {
		$scope.films = data;//.splice(0, 5);
	});
	
	$scope.ajouter = function () {
		$location.url('/films/edit/undefined');
	};
};

function FilmDetailCtrl($scope, $routeParams, $http,$location) {
	$(".nav .active").removeClass("active");
	$("#navigationFilms").addClass("active");
	  $http.get('services/film/id/' + $routeParams.filmId).success(function(data) {
		    $scope.film = data;
	  });
	  $http.get('services/participation/film/' + $routeParams.filmId).success(function(data) {
		    $scope.participations = data;
	  });
	  
	  $scope.edit = function () {
		  $location.url('/films/edit/'+$scope.film.id);
	  };
};

function FilmEditCtrl($scope, $routeParams, $http,$location) {
	$(".nav .active").removeClass("active");
	$("#navigationFilms").addClass("active");
	if($routeParams.filmId!='undefined') {
		$http.get('services/film/id/' + $routeParams.filmId).success(function(data) {
			$scope.film = data;
		});
		$http.get('services/participation/film/' + $routeParams.filmId).success(function(data) {
			$scope.participations = data;
		});
		$http.get('services/acteur/all').success(function(data) {
			$scope.acteurs = data;
		});
	}
	
	$scope.save = function () {
		$http.post('services/film',$scope.film).success(function(data) {
			$scope.film = data;
			$location.url('/films/'+$scope.film.id);
		});	
	};
	
	$scope.efface = function () {
		$http.delete('services/film/'+$scope.film.id).success(function() {
			$scope.film = null;
			$location.url('/films');
		});	
	};
	
	$scope.deleteParticipation = function (id) {
		$http.delete('services/participation/'+id).success(function() {
		    var participations = $scope.participations;
		    for (var i = 0, ii = participations.length; i < ii; i++) {
		      if (id === participations[i].id) {
		    	  $scope.participations.splice(i, 1);
		      }
		    }
		});	
	};
	
	$scope.addParticipation = function (acteurId) {
		$scope.participation.film = $scope.film;
		var acteurs = $scope.acteurs;
		for(var i=0, ii = acteurs.length;i < ii; i++) {
		      if (acteurId === acteurs[i].id) {
		    	  $scope.participation.acteur = acteurs[i];
		      }			
		}
		$http.post('services/participation',$scope.participation).success(function(data) {
			$scope.participations.push($scope.participation);
		});	
	};
};

/*======================
 * ACTEURS
 *======================*/


function ActeurListCtrl($scope, $http, $location) {
	$scope.query = '';
	$(".nav .active").removeClass("active");
	$("#navigationActeurs").addClass("active");
	$http.get('services/acteur/all').success(function(data) {
		$scope.acteurs = data;//.splice(0, 5);
	});
	
	$scope.ajouter = function () {
		$location.url('/acteurs/edit/undefined');
	};
};

function ActeurDetailCtrl($scope, $routeParams, $http, $location) {
	$(".nav .active").removeClass("active");
	$("#navigationActeurs").addClass("active");
	  $http.get('services/acteur/id/' + $routeParams.acteurId).success(function(data) {
		    $scope.acteur = data;
	  });
	  $http.get('services/participation/acteur/' + $routeParams.acteurId).success(function(data) {
		    $scope.participations = data;
	  });
	  
	  $scope.edit = function () {
		  $location.url('/acteurs/edit/'+$scope.acteur.id);
	  };
};

function ActeurEditCtrl($scope, $routeParams, $http,$location) {
	$(".nav .active").removeClass("active");
	$("#navigationActeurs").addClass("active");
	if($routeParams.acteurId!='undefined') {
		$http.get('services/acteur/id/' + $routeParams.acteurId).success(function(data) {
			$scope.acteur = data;
		});
		$http.get('services/participation/acteur/' + $routeParams.acteurId).success(function(data) {
			$scope.participations = data;
		});
		$http.get('services/film/all').success(function(data) {
			$scope.films = data;
		});
	}
	
	$scope.save = function () {
		$http.post('services/acteur',$scope.acteur).success(function(data) {
			$scope.acteur = data;
			$location.url('/acteurs/'+$scope.acteur.id);
		});	
	};
	
	$scope.efface = function () {
		$http.delete('services/acteur/'+$scope.acteur.id).success(function() {
			$scope.acteur = null;
			$location.url('/acteurs');
		});	
	};
	
	$scope.deleteParticipation = function (id) {
		$http.delete('services/participation/'+id).success(function() {
		    var participations = $scope.participations;
		    for (var i = 0, ii = participations.length; i < ii; i++) {
		      if (id === participations[i].id) {
		    	  $scope.participations.splice(i, 1);
		      }
		    }
		});	
	};
	
	$scope.addParticipation = function (filmId) {
		$scope.participation.acteur = $scope.acteur;
		var films = $scope.films;
		for(var i=0, ii = films.length;i < ii; i++) {
		      if (filmId === films[i].id) {
		    	  $scope.participation.film = films[i];
		      }			
		}
		$http.post('services/participation',$scope.participation).success(function(data) {
			$scope.participations.push($scope.participation);
		});	
	};
};
