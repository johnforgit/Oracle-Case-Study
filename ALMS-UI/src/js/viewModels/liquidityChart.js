define([
  "knockout",
  "ojs/ojarraydataprovider",
  "ojs/ojchart",
  "ojs/ojknockout",
  "ojs/ojselectsingle",
  "ojs/ojbootstrap"
], function (ko, ArrayDataProvider) {
  function LiquidityChartViewModel() {
    const self = this;

    self.orientationValue = ko.observable("vertical");
    self.stackValue = ko.observable("off");

    self.orientationOptions = new ArrayDataProvider([
      { value: "vertical", label: "Vertical" },
      { value: "horizontal", label: "Horizontal" }
    ], { keyAttributes: "value" });

    self.stackOptions = new ArrayDataProvider([
      { value: "off", label: "Off" },
      { value: "on", label: "On" }
    ], { keyAttributes: "value" });

    self.chartItems = ko.observableArray([]);
    self.dataProvider = new ArrayDataProvider(self.chartItems, {
      keyAttributes: "id"
    });

    self.loadData = function () {
      fetch("http://127.0.0.1:8081/api/liquidity-gap")
        .then(response => response.json())
        .then(data => {
          const records = Array.isArray(data) ? data : [data];
          const transformed = [];

          records.forEach((entry, index) => {
            const group = entry.bucketLabel || `Bucket ${index + 1}`;
            transformed.push(
              { id: `${group}-inflow`, series: "Inflow", group, value: entry.inflow },
              { id: `${group}-outflow`, series: "Outflow", group, value: entry.outflow }
            );
          });

          self.chartItems(transformed);
        })
        .catch(err => console.error("Error loading chart data:", err));
    };

    self.loadData();
  }

  return LiquidityChartViewModel;
});