'use strict';

/**
 * @ngdoc service
 * @name publicApp.TxService
 * @description
 * # TxService
 * Service in the publicApp.
 */
angular.module('app')
  .service('txService', function ($http) {
    
	  this.createTx =  function(createTxUrl,param) {
		  
		  $http.post(createTxUrl,param, {
			  
		  })
		  .success(function(){})
		  .error(function(){});
	  };
	  
	  //get all transactions
	  this.getTransactions = function() {
		  
	  };
  });
