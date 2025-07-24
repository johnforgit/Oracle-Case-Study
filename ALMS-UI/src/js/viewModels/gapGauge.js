define(['knockout', 'ojs/ojcore', 'ojs/ojknockout', 'ojs/ojgauge'], function (ko, oj) {
  function GapGaugeViewModel() {
    const self = this;
    self.value1 = ko.observable(0);
    self.gapType = ko.observable("Loading...");

    // Computed observable for dynamic color
    self.gaugeColor = ko.computed(function () {
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

  return new GapGaugeViewModel();
});
