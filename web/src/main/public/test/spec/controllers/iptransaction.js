'use strict';

describe('Controller: IptransactionCtrl', function () {

  // load the controller's module
  beforeEach(module('publicApp'));

  var IptransactionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    IptransactionCtrl = $controller('IptransactionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
