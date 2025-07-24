// DURATION GAP Analysis
define(["require", "exports", "knockout", "ojs/ojbootstrap", "ojs/ojconverterutils-i18n", "oj-c/meter-bar","oj-c/input-date-picker", "ojs/ojknockout"], function (require, exports, ko, Bootstrap, ojconverterutils_i18n_1,ojbootstrap_1) {
    "use strict";
    
    function DurationGapModel() {
        var self=this;
        self.gapDurationDate = ko.observable(ojconverterutils_i18n_1.IntlConverterUtils.dateToLocalIsoDateString(new Date()));
        self.gapDurationValue = ko.observable();
        self.gapBarColor = ko.observable("black");
        self.gapDurationDate.subscribe(function(newValue) {
            var endpointURL = `http://localhost:8081/api/duration-gap?reportingDate=${newValue}`;
            console.log(endpointURL);
            fetch(endpointURL, {
                    method: 'GET',
                    headers: {'Content-Type': 'application/json'}
               })
               .then(response => {
                    if (!response.ok) throw new Error('Network error');
                    return response.json();
               })
               .then(data => {
                    self.gapDurationValue(data.durationGap);
                    self.gapBarColor(self.gapDurationValue()<-1 || self.gapDurationValue()>1 ? "red":"green");  
               })
               .catch(error => {
                    console.error('Error:', error);
               });
            console.log("Observable gapDurationDate changed: " + newValue);
        });
        self.gapDurationValue.subscribe(function(newValue){
            console.log(`Observable gapDurationValue changed:${newValue}`);
        });
        
        
        self.rawValue = ko.observable();
        self.rawValueText = ko.computed(() => {
            const rawValue = this.rawValue();
            return JSON.stringify(rawValue);
        });
        self.transientValue = ko.observable();
        self.referenceLinesWithLabels = [
            { value: -1, color: 'danger', position: 'end', label: '-1' },
            { value: 1,color: 'danger', position: 'start', label: '1' }
        ];
        self.getTooltip = (type, detail) => { // ---CHECK---
            let tooltip;
            if (type === 'ref')
                tooltip = `Value: ${detail.value}; Reference Lines: Low 33, Medium 67`;
            else if (type === 'th')
                tooltip = `Value: ${detail.value}; Thresholds: Low 33, Medium 67, High 100`;
            else if (type === 'baseline')
                tooltip = `Value: ${detail.value}; Min: -100, Max: 100, Baseline: 10`;
            else
                tooltip = `Value: ${detail.value}`;
            return tooltip;
        };
    }
    // Bootstrap.whenDocumentReady().then(() => {
    //     ko.applyBindings(new SimpleModel(), document.getElementById('div1'));
    // });
    return new DurationGapModel();
});