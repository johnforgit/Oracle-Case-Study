define(["require", "exports", "knockout", "ojs/ojbootstrap", "ojs/ojmutablearraydataprovider", "text!../quarterData.json", "ojs/ojknockout", "oj-c/line-chart"], function (require, exports, ko, ojbootstrap_1, MutableArrayDataProvider, quarterData) {
    "use strict";
    
    function LineChartModel() {
        function transformToChartSeries(inputData) {
            const output = [];
            inputData.forEach((item, index) => {
                output.push(
                {
                    id: item.reportingDate,
                    series: "Value At Risk",
                    groupId: item.reportingDate, // using reportingDate instead of quarter name
                    value: item.valueAtRisk  // scale if needed
                },
                {
                    id: item.reportingDate,
                    series: "Portfolio Value",
                    groupId: item.reportingDate,
                    value: item.portfolioValue  // scale if needed
                }
                );
            });
            return output;
            }

        var self=this;
        self.orientationValue = ko.observable("vertical");
        self.dataProvider=ko.observable();
        self.seriesId = ko.observable("VAR");
        self.seriesId2 = ko.observable("Portfolio");
        fetch('http://localhost:8081/api/value-at-risk/timeseries', {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        })
        .then(response => {
            if (!response.ok) throw new Error('Network error');
            console.log("HERE 1");
            return response.json();
        })
        .then(data => {
            console.log("HERE 2");
            self.dataProvider(new MutableArrayDataProvider(transformToChartSeries(data), {
                keyAttributes: "reportingDate",
            }));
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
        
        
    }
    // (0, ojbootstrap_1.whenDocumentReady)().then(() => {
    //     ko.applyBindings(new LineChartModel(), document.getElementById("line-chart-container"));
    // });
    return new LineChartModel();
});