define(['knockout', 'ojs/ojcore', 'ojs/ojknockout', 'ojs/ojgauge', 'ojs/ojdatetimepicker'], function (ko, oj) {
  function AssetCoverageGaugeViewModel() {
    const self = this;

    self.acrValue = ko.observable(0);
    self.gaugeColor1 = ko.observable('#0277bd');
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
            self.gaugeColor1('#2e7d32'); // Green
          } else if (acr >= 1.5) {
            self.gaugeColor1('#ffb300'); // Amber
          } else {
            self.gaugeColor1('#c62828'); // Red
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
  function GapGaugeViewModel() {
    const self = this;
    self.value1 = ko.observable(0);
    self.gapType = ko.observable("Loading...");

    // Computed observable for dynamic color
    self.gaugeColor2 = ko.computed(function () {
      const type = self.gapType();
      if (type === 'Asset-sensitive') return '#2e7d32';  // Green
      if (type === 'Liability-sensitive') return '#c62828';  // Red
      return '#0277bd';  // Default blue
    });

    // Fetch data from API
    fetch("http://127.0.0.1:8081/api/gap-analysis")
      .then(response => response.json())
      .then(data => {
        self.value1(data.gapValue);
        self.gapType(data.gapType);
      });

    return self;
  }

  const ob1=new GapGaugeViewModel();
  const ob2=new AssetCoverageGaugeViewModel();
  return {...ob1,...ob2};
});
