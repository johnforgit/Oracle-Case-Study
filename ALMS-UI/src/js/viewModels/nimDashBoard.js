define(["require", "exports", "knockout", "ojs/ojbootstrap", "ojs/ojarraydataprovider", "ojs/ojknockout", "ojs/ojchart", "ojs/ojtoolbar"], function (require, exports, ko, ojbootstrap_1, ArrayDataProvider) {
    "use strict";
    
    function ChartModel() {
        var self=this;
        self.dataProvider1=ko.observable();
        self.dataProvider2=ko.observable();
        function transformToChartSeries(inputData) {
            const output1 = [];
            const output2 = [];
            inputData.forEach((item, index) => {
                output1.push(
                {
                    id: Number(item.year),
                    series: "Income",
                    group: item.year, 
                    value: Number(item.income )
                },
                {
                    id: Number(item.year),
                    series: "Expense",
                    group: item.year,
                    value: Number(item.expense )
                });
                output2.push(
                {
                    id: Number(item.year),
                    series: "NIM",
                    group: item.year,
                    value: Number(item.nim)  
                }
                );
            });
            return {'output1':output1,'output2':output2};
            }
        fetch('http://127.0.0.1:8081/api/net-interest-margin-by-year', {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        })
        .then(response => {
            if (!response.ok) throw new Error('Network error');
            return response.json();
        })
        .then(data => {
            console.log(data);
            data = transformToChartSeries(data)
            console.log(data);
            self.dataProvider1(new ArrayDataProvider(data.output1, {
                keyAttributes: "id",
            }));
            self.dataProvider2(new ArrayDataProvider(data.output2, {
                keyAttributes: "id",
            }));
        })
        .catch(error => {
            console.error('Error:', error);
        });
        this.stackValue1 = ko.observable('off');
        this.orientationValue1 = ko.observable('vertical');
        this.stackValue2 = ko.observable('off');
        this.orientationValue2 = ko.observable('vertical');
        
    }
    // (0, ojbootstrap_1.whenDocumentReady)().then(() => {
    //     ko.applyBindings(new ChartModel(), document.getElementById('chart-container'));
    // });
    return new ChartModel();
});