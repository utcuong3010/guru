'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:CreatetxCtrl
 * @description
 * # CreatetxCtrl
 * Controller of the publicApp
 */

angular.module('app')
.controller('CreatetxCtrl',function ($scope, txService) {
	
	var createTxUrl = "/transaction/create";
  
	$scope.createTx = function() {
		var form = {
				name: $scope.name,
				x: $scope.x,
				y: $scope.y,
				width:$scope.width,
				height:$scope.height,
				file : $scope.sourceFile
									
		};
		console.log("params:" + JSON.stringify(form));
		
		txService.createTx(createTxUrl,form);	
		
	}
});

