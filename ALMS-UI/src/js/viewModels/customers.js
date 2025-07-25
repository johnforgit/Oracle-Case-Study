define([
  "require", "exports", "knockout", "ojs/ojbootstrap",
  "ojs/ojarraydataprovider", "ojs/ojlistdataproviderview",
  "ojs/ojdataprovider", "ojs/ojknockout", "ojs/ojtable", 
  "ojs/ojinputtext"
], function (
  require, exports, ko, ojbootstrap_1,
  ArrayDataProvider, ListDataProviderView,
  ojdataprovider_1
) {
  "use strict";

  function ViewModel() {
    const self = this;

    self.filter = ko.observable('');
    self.customerArray = ko.observableArray([]);

    self.dataprovider = ko.computed(function () {
      let filterCriterion = null;
      if (self.filter() && self.filter() !== '') {
        filterCriterion = ojdataprovider_1.FilterFactory.getFilter({
          filterDef: { text: self.filter() }
        });
      }
      const arrayDataProvider = new ArrayDataProvider(self.customerArray(), {
        keyAttributes: 'customerID'
      });
      return new ListDataProviderView(arrayDataProvider, {
        filterCriterion: filterCriterion
      });
    });

    self.handleRawValueChanged = function (event) {
      self.filter(event.detail.rawValue);
    };

    // Fetch data from backend API
    fetch("http://localhost:8081/api/customer-data")
      .then(response => response.json())
      .then(data => {
        console.log("Fetched customer data:", data);
        self.customerArray(data);
      })
      .catch(err => {
        console.error("Error fetching customer data:", err);
      });

    self.highlightingCellRenderer = function (context) {
      let field = context.column.field;
      let data = context.row[field] ? context.row[field].toString() : '';
      let filterString = self.filter();
      let spanNode = document.createElement('span');

      if (filterString && filterString.length > 0) {
        const index = data.toLowerCase().indexOf(filterString.toLowerCase());
        if (index > -1) {
          spanNode.innerHTML = data.substring(0, index)
            + '<b>' + data.substring(index, index + filterString.length) + '</b>'
            + data.substring(index + filterString.length);
        } else {
          spanNode.textContent = data;
        }
      } else {
        spanNode.textContent = data;
      }

      context.parentElement.appendChild(spanNode);
    };

    // Columns updated to match your backend response
    self.columnArray = [
      { headerText: 'Customer ID', field: 'customerID', renderer: self.highlightingCellRenderer, id: 'custId' },
      { headerText: 'Name', field: 'name', renderer: self.highlightingCellRenderer, id: 'name' },
      { headerText: 'Date of Birth', field: 'dateOfBirth', renderer: self.highlightingCellRenderer, id: 'dob' },
      { headerText: 'Email', field: 'email', renderer: self.highlightingCellRenderer, id: 'email' },
      { headerText: 'Phone', field: 'phone', renderer: self.highlightingCellRenderer, id: 'phone' },
      { headerText: 'Address', field: 'address', renderer: self.highlightingCellRenderer, id: 'address' },
      { headerText: 'Risk Profile', field: 'riskProfile', renderer: self.highlightingCellRenderer, id: 'risk' }
    ];
  }

  return new ViewModel();
});