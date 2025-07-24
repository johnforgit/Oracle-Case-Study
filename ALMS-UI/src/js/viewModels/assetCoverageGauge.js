define(['knockout', 'ojs/ojcore', 'ojs/ojknockout', 'ojs/ojgauge', 'ojs/ojdatetimepicker'], function (ko, oj) {
  function AssetCoverageGaugeViewModel() {
    const self = this;

    self.acrValue = ko.observable(0);
    self.gaugeColor = ko.observable('#0277bd');
    self.reportingDate = ko.observable("2025-06-30"); // Default date (ISO format)
    self.bvta = ko.observable(0);
    self.ia = ko.observable(0);
    self.cl = ko.observable(0);
    self.totalDebt = ko.observable(0);

    self.fetchACR = function () {
      const date = self.reportingDate();
      const url = `http://127.0.0.1:8081/api/asset-coverage?reportingDate=${date}`;

      fetch(url)
        .then(response => response.json())
        .then(data => {
          const acr = parseFloat(data.assetCoverageRatio || 0);
          self.acrValue(acr);
          self.bvta(data.bvta);
  self.ia(data.ia);
  self.cl(data.cl);
  self.totalDebt(data.totalDebt);

          if (acr >= 2.0) {
            self.gaugeColor('#2e7d32'); // Green
          } else if (acr >= 1.5) {
            self.gaugeColor('#ffb300'); // Amber
          } else {
            self.gaugeColor('#c62828'); // Red
          }
        })
        .catch(err => {
          console.error("Error fetching ACR data:", err);
          self.acrValue(0);
        });
    };

    // Fetch on initial load
    self.fetchACR();

    // React to date changes
    self.reportingDate.subscribe(function () {
      self.fetchACR();
    });

    return self;
  }

  return new AssetCoverageGaugeViewModel();
});
