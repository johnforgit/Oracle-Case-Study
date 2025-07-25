define([
  "require",
  "exports",
  "knockout",
  "ojs/ojbootstrap",
  "ojs/ojarraydataprovider",
  "ojs/ojknockout",
  "ojs/ojchart",
], function (require, exports, ko, ojbootstrap_1, ArrayDataProvider) {
  "use strict";

  function computeAssetCount(inputData) {
    const output = [];
    const assetTypeCount = {};

    inputData.forEach((asset) => {
      const type = asset.assetType;
      assetTypeCount[type] = (assetTypeCount[type] || 0) + 1;
    });

    Object.entries(assetTypeCount).forEach(([assetType, count], index) => {
      output.push({
        id: index + 1,
        series: assetType,
        group: "Group A",
        value: count,
      });
    });
    return output;
  }
  function computeAssetValue(inputData) {
    const output = [];
    const assetTypeValue = {};

    inputData.forEach((asset) => {
      const type = asset.assetType;
      assetTypeValue[type] = (assetTypeValue[type] || 0) + asset.assetValue;
    });

    Object.entries(assetTypeValue).forEach(([assetType, assetValue], index) => {
      output.push({
        id: index + 1,
        series: assetType,
        group: "Group A",
        value: assetValue,
      });
    });
    return output;
  }
  function AssetDashboardModel() {
    var self = this;
    self.dataProvider1 = ko.observable();
    self.dataProvider2 = ko.observable();
    self.dataDate = ko.observable();
    self.totalAssetValue = ko.observable();

    fetch("http://127.0.0.1:8081/api/assets", {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => {
        if (!response.ok) throw new Error("Network error");
        return response.json();
      })
      .then((data) => {
        // Calculating pychart based on asset Types
        console.log(data);
        var modifiedDataCount = computeAssetCount(data);
        var modifiedDataValue = computeAssetValue(data);
        self.dataProvider1(
          new ArrayDataProvider(modifiedDataCount, {
            keyAttributes: "id",
          })
        );
        self.dataProvider2(
          new ArrayDataProvider(modifiedDataValue, {
            keyAttributes: "id",
          })
        );

        // Calculating total asset value as of today
        const assets = [
          /* your JSON array */
        ];
        const today = new Date();
        let totalAssetValue = 0;
        data.forEach((asset) => {
          if (asset.maturityDate && asset.assetValue !== null) {
            const maturity = new Date(asset.maturityDate);
            if (maturity >= today) {
              totalAssetValue += asset.assetValue;
            }
          }
        });
        self.totalAssetValue(totalAssetValue);
        self.dataDate(today.toISOString().split("T")[0]);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }
  return new AssetDashboardModel();
});
