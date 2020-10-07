var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

	$scope.servicos = new Object();

	$scope.salvar = function() {
		$http.post("http://localhost:8080/servicos", {
			'id' : $scope.id,
			'nome' : $scope.nome,
			'data' : $scope.data

		})

	};

	$scope.getAll = function() {
		$http.get("http://localhost:8080/servicos").then(function(resposta) {
			$scope.servicos = resposta.data;
		});
	}
	$scope.getAll();
});
