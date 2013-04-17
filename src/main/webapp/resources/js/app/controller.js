
var viewController = {
    model: Object.create(greTool),
    initialize: function() {
        this.model.delegate = this;
        
        // setup UI
        this.setupUI();
    },
    setupUI: function() {
        // setup all ui elements
        $('button').button();
        $('.top-bar .menu').menu();
    },
    showFoundNodes: function(nodeList) {

        // TODO: show the results in a modal dialog.
        var resultsDiv, resultsTable, tr, td, model;

        resultsDiv = $('.results');

        resultsTable = view.buildResultsTable(nodeList);
        resultsTable.prop('class', 'results-table');

        resultsDiv.append(resultsTable);

        //set up events for the newly created results table
        model = this.model;
        $('.results td').click(function() {
            var curNode = JSON.parse($(this).text());
            model.selectConceptFromResult(curNode);
        });

        // show the results table
        resultsDiv.show();
    },
    showCurrentConcept: function(curNode) {
        $('.editor').text(curNode.content);
    },
    buildMainContainer: function() {

        view.init();

        // setup events for search input
        var that = this;
        view.tagFinder.find('input').blur(function() {
            // use the model to find the nodes that match
            // the given criteria
            that.model.findNodes($(this).val());

        });

    },
    closeResults: function() {

        $('.results').empty().hide();

    },
    buildResultsTable: function(nodeList) {
        var tr, td, resultsTable;
        
        resultsTable= $('<table>');

        for (var i = 0; i < nodeList.length; ++i) {

            tr = $('<tr>');

            td = $('<td>');
            td.prop('class', 'result-node');
            td.text(JSON.stringify(nodeList[i]));

            tr.append(td);

            resultsTable.append(tr);
        }
        return resultsTable;
    }
};
