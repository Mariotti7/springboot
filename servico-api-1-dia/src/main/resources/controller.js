var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
  $scope.id="1";
  $scope.nome="Luizaa";


$scope.salvar = function() {
  $http.post("http://localhost:8080/servicos", {
    'id':$scope.id,
    'nome':$scope.nome,
    'data':$scope.data

  })
  
};   

$scope.get = function()
{
  $http.get("http://localhost:8080/servicos")
  .then(function(resposta) {
    console.info(resposta);
  });
}  

});
