define(["require", "exports", "knockout", "ojs/ojbootstrap", "ojs/ojarraydataprovider", "ojs/ojknockout", "ojs/ojchart"], function (require, exports, ko, ojbootstrap_1, ArrayDataProvider) {
    "use strict";

    function computeLiabilityCount(inputData){
        const output = [];
        const liabilityTypeCount = {};

        inputData.forEach(liability => {
            const type = liability.liabilityType;
            liabilityTypeCount[type] = (liabilityTypeCount[type] || 0) + 1;
        });

        Object.entries(liabilityTypeCount).forEach(([liabilityType, count], index) => {
            output.push({
                id: index + 1,
                series: liabilityType,
                group: "Group A",
                value: count
            });
        });
        return output;
    }
    function computeLiabilityValue(inputData){
        const output = [];
        const liabilityTypeValue = {};

        inputData.forEach(liability => {
            const type = liability.liabilityType;
            liabilityTypeValue[type] = (liabilityTypeValue[type] || 0) + liability.liabilityValue;
        });

        Object.entries(liabilityTypeValue).forEach(([liabilityType, liabilityValue], index) => {
            output.push({
                id: index + 1,
                series: liabilityType,
                group: "Group A",
                value: liabilityValue
            });
        });
        return output;
    }
    function LiabilityDashboardModel() {
        var self=this;
        self.dataProvider3=ko.observable();
        self.dataProvider4=ko.observable();
        self.dataDate=ko.observable();
        self.totalLiabilityValue = ko.observable();

        fetch('http://127.0.0.1:8081/api/liability', {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        })
        .then(response => {
            if (!response.ok) throw new Error('Network error');
            return response.json();
        })
        .then(data => {

            // Calculating pychart based on asset Types
            console.log(data);
            var modifiedDataCount=computeLiabilityCount(data);
            var modifiedDataValue=computeLiabilityValue(data);
            self.dataProvider3(new ArrayDataProvider(modifiedDataCount, {
                keyAttributes: "id",
            }));
            self.dataProvider4(new ArrayDataProvider(modifiedDataValue, {
                keyAttributes: "id",
            }));

            // Calculating total asset value as of today
            const assets = [ /* your JSON array */ ];
            const today = new Date();
            let totalLiabilityValue = 0;
            data.forEach(liability => {
            if (liability.maturityDate && liability.liabilityValue !== null) {
                const maturity = new Date(liability.maturityDate);
                if (maturity >= today) {
                    totalLiabilityValue += liability.liabilityValue;
                }
            }
            });
            self.totalLiabilityValue(totalLiabilityValue);
            self.dataDate(today.toISOString().split('T')[0]);
        })
        .catch(error => {
            console.error('Error:', error);
        });
        
    };
    return new LiabilityDashboardModel();
});