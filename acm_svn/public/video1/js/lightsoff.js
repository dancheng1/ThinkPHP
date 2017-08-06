;(function ($, window, document, undefined) {

    var pluginName = 'lightsOff';

    var options;
    var defaults = {
        color: '#2196F3',
        opacity: '0.9',
        zIndex: '999',
        switchSelector: '.switch',
        durationLightsOff: 400,
        durationLightsOn: 400,
        allowScrolling: true
    };

    var body = $('body');
    var overlayClass = 'lightsOffOverlay';
    var overlaySelector = '.' + overlayClass;
    var video;

    // Public API and methods
    var PluginApi = {
        extend: function(name, method) {
            PluginApi[name] = method;
            return this;
        },
        init: function(PublicOptions) {
            options = $.extend(true, {}, defaults, PublicOptions);
            video = this;

            // Overlay Styling
            $('<style>' +
                 overlaySelector + ' {' +
                    'position: absolute;' +
                    'display: none;' +
                    'background: '+ options.color + ';' +
                    'opacity: ' + options.opacity + ';' +
                    'z-index: ' + options.zIndex + ';' +
                '}' +
               '</style>').appendTo(body);

            // Handlers
            if (null !== options.switchSelector) {
                body.on('click', options.switchSelector, function() {
                    PluginApi.show.apply(video, arguments);
                });
            }
            body.on('click', overlaySelector, function() {
                PluginApi.hide.apply(video, arguments);
            });

            // Recalculates chunk positions on window resize
            $(window).on('resize', function() {
                if ($(overlaySelector).is(':visible')) {
                    overlayDraw();
                }
            });

            return this;
        },
        show: function() {
            overlayDraw();
            overlayState(true);
            return this;
        },
        hide: function() {
            overlayState(false);
            return this;
        }
    };

    // Private Methods
    var overlayDraw = function () {
        var offset = video.offset();

        var vh = video.height();
        var vw = video.width();
        var vax = offset.left;
        var vay = offset.top;
        var vbx = vax + vw;
        var vby = vay + vh;
        var dhs = $(document).height() - vby;
        var dws = $(document).width() - vbx;

        var chunkData = [
            [0, vay, vby, 0, vby, 0, vay, vby], //top
            [0, 0, 0, vax, vax, vbx, vbx, vbx], //left
            [vay, vh, dhs, vay, dhs, vay, vh, dhs], //height
            [vax, vax, vax, vw, vw, dws, dws, dws] //width
        ];

        for (var id = 0; id < 8; ++id) {

            var chunkSelector =  '#' + overlayClass + id;

            if ($(chunkSelector).length === 0) {
                // Add overlay chunk to body
                $('<div />').attr({'id' : overlayClass + id, 'class' : overlayClass}).appendTo(body);
            }

            $(chunkSelector).css({
                top: chunkData[0][id],
                left: chunkData[1][id],
                right: 0,
                height: chunkData[2][id],
                width: chunkData[3][id]
            });
        }
    };
    var overlayState = function (state) {
        var overlay = $(overlaySelector);
        var isVisible = overlay.is(':visible');

        if (state && !isVisible || !state && isVisible) {
            var fireEvent = true;
            overlay[state ? 'fadeIn' : 'fadeOut']
            (state ? options.durationLightsOff : options.durationLightsOn, function() {
                if (!options.allowScrolling) {
                    body.css('overflow', state ? 'hidden' : 'auto');
                }
                if (fireEvent) { // Called once per chunk but trigger the event just one time
                    fireEvent = false;
                    $.event.trigger(state ? 'lightsOff' : 'lightsOn');
                }
            });
        }
    };

    // Attach the plugin to jQuery namespace
    $.fn[pluginName] = function(method) {
        if (PluginApi[method]) {
            return PluginApi[method].apply(this, Array.prototype.slice.call(arguments, 1));
        }
        else if (typeof method === 'object' || !method) {
            return PluginApi.init.apply(this, arguments);
        }
        else {
            $.error('Method ' + method + 'does not exist');
        }
    };
}(jQuery, window, document));