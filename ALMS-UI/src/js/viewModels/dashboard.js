define([
  'knockout',
  'ojs/ojchart',
  'ojs/ojselectcombobox',
  'ojs/ojdatetimepicker',
  'ojs/ojformlayout',
  'ojs/ojbutton',
  'ojs/ojslider',
  'ojs/ojprogress-bar'
], function (ko) {
  function AlmDashboardViewModel() {
    const self = this;

    self.startDate = ko.observable();
    self.endDate = ko.observable();
    self.selectedScenario = ko.observable("base");
    self.rateShock = ko.observable(0);

    self.barGroups = ko.observableArray(["Bank A", "Bank B", "Bank C"]);
    self.barSeries = ko.observableArray([
      { name: "NIM", items: [3.2, 2.8, 3.5] }
    ]);

    self.simulate = function () {
      const shock = self.rateShock();
      let baseNIMs = [3.2, 2.8, 3.5];
      let adjusted = baseNIMs.map(nim => (nim + shock * 0.2).toFixed(2));
      self.barSeries([{ name: `NIM (Shock ${shock}%)`, items: adjusted.map(Number) }]);
    };

    // Export CSV
    self.exportCSV = function () {
      const headers = ["Bank", "NIM"];
      const rows = self.barGroups().map((bank, i) => [bank, self.barSeries()[0].items[i]]);
      let csv = [headers.join(",")].concat(rows.map(r => r.join(","))).join("\n");

      let blob = new Blob([csv], { type: "text/csv" });
      let a = document.createElement("a");
      a.href = URL.createObjectURL(blob);
      a.download = "alm_metrics.csv";
      a.click();
    };

    // Export PDF (very basic)
    self.exportPDF = function () {
      let win = window.open("", "", "height=600,width=800");
      win.document.write("<h3>ALM Dashboard Export</h3>");
      win.document.write("<ul>");
      self.barGroups().forEach((bank, i) => {
        win.document.write(`<li>${bank}: ${self.barSeries()[0].items[i]}</li>`);
      });
      win.document.write("</ul>");
      win.print();
    };
  }

  return new AlmDashboardViewModel();
});