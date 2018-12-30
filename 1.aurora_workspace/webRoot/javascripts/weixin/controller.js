/**
 * Created by mouse on 2015/9/11.
 */

hec.controller('HecController', [
    '$scope',
    '$state',
    '$timeout',
    function ($scope, $state, $timeout) {
        $scope.goState = function (state) {
            $state.go(state);
            /*if (sec && sec > 0) {
             $timeout(function () {
             $state.go(state);
             }, sec);
             } else {

             }*/
        };

    }]);
