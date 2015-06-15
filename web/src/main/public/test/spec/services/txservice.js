'use strict';

describe('Service: TxService', function () {

  // load the service's module
  beforeEach(module('publicApp'));

  // instantiate service
  var TxService;
  beforeEach(inject(function (_TxService_) {
    TxService = _TxService_;
  }));

  it('should do something', function () {
    expect(!!TxService).toBe(true);
  });

});
