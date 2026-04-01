/**
 * Copyright 2005 Darren L. Spurgeon
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----
 *
 * liveUpdater function and other portions copyright by:
 * Copyright 2004 Leslie A. Hensley (hensleyl@papermountain.org)
 *   you have a license to do what ever you like with this code
 *   orginally from Avai Bryant
 *   http://www.cincomsmalltalk.com/userblogs/avi/blogView?entry=3268075684
 */

//
// GLOBAL OPTIONS
//

var isSafari = false;
var isMoz = false;
var isIE = false;

if (navigator.userAgent.indexOf("Safari") > 0) {
  isSafari = true;
  isMoz = false;
  isIE = false;
}
else if (navigator.product == "Gecko") {
  isSafari = false;
  isMoz = true;
  isIE = false;
} else {
  isSafari = false;
  isMoz = false;
  isIE = true;
}


//
// GLOBAL FUNCTIONS
//

/* Functions to handle browser incompatibilites */
function eventElement(event) {
  if (isMoz) {
    return event.currentTarget;
  } else {
    return event.srcElement;
  }
}

function addKeyListener(element, listener) {
  if (isSafari)
    element.addEventListener("keydown",listener,false);
  else if (isMoz)
    element.addEventListener("keypress",listener,false);
  else
    element.attachEvent("onkeydown",listener);
}

function addListener(element, type, listener) {
  if (element.addEventListener) {
    element.addEventListener(type, listener, false);
  } else {
    element.attachEvent('on' + type, listener);
  }
}

function removeListener(element, type, listener) {
  if (element.removeEventListener) {
    element.removeEventListener(type, listener, false);
  } else {
    element.detachEvent('on' + type, listener);
  }
}

/* XML Helper functions */
function flatten(node) {
  if (node.nodeType == 1) {
    return '<' + node.nodeName + flattenAttributes(node) + '>' +
    flattenChildren(node.childNodes) + '</' + node.nodeName + '>';
  } else if(node.nodeType == 3) {
    return node.nodeValue;
  }
}

function flattenAttributes(node) {
  var buffer = '';
  for (var i=0;i<node.attributes.length;i++) {
    var attribute = node.attributes[i];
    buffer += ' '+ attribute.name + '="' + attribute.value + '"';
  }
  return buffer;
}

function flattenChildren(nodes) {
  var buffer = '';
  if (nodes.length > 0) {
    for (var i=0;i<nodes.length;i++) {
      buffer += flatten(nodes[i]);
    }
  }
  return buffer;
}

function copyAttributes(source, destination) {
  for (var i=0;i<source.attributes.length;i++) {
    var attribute = source.attributes[i];
    destination.setAttribute(attribute.name, attribute.value);
  }
  destination.className = source.getAttribute('class');
}

function getElementY(element){
  var targetTop = 0;
  if (element.offsetParent) {
    while (element.offsetParent) {
      targetTop += element.offsetTop;
      element = element.offsetParent;
    }
  } else if (element.y) {
    targetTop += element.y;
  }
  return targetTop;
}

function getElementX(element){
  var targetLeft = 0;
  if (element.offsetParent) {
    while (element.offsetParent) {
      targetLeft += element.offsetLeft;
      element = element.offsetParent;
    }
  } else if (element.x) {
    targetLeft += element.yx;
  }
  return targetLeft;
}



/**
 * Returns true if an element has a specified class name
 */
function hasClass(node, className) {
  if (node.className == className) {
    return true;
  }
  var reg = new RegExp('(^| )'+ className +'($| )')
  if (reg.test(node.className)) {
    return true;
  }
  return false;
}

/**
 * Adds a class name to an element
 */
function addClass(node, className) {
  if (hasClass(node, className)) {
    return false;
  }
  node.className += ' '+ className;
  return true;
}

/**
 * Removes a class name from an element
 */
function removeClass(node, className) {
  if (!hasClass(node, className)) {
    return false;
  }
  node.className = eregReplace('(^| )'+ className +'($| )', '', node.className);
  return true;
}

/**
 * Emulate PHP's ereg_replace function in javascript
 */
function eregReplace(search, replace, subject) {
  return subject.replace(new RegExp(search,'g'), replace);
}



//
// LIVE UPDATE CORE
//
/*
  liveUpdater returns the live update function to use
  uriFunc: The function to generate the uri
  postFunc: <optional> Function to run after processing is complete
  preFunc: <optional> Function to run before processing starts
*/
function liveUpdater(uriFunc, handlerFunc, preFunc, emptyFunc, errorFunc) {
  if (!handlerFunc) handlerFunc = function() {};
  if (!preFunc) preFunc = function () {};
  if (!emptyFunc) emptyFunc = function () {};
  if (!errorFunc) errorFunc = function () {};

  return createLiveUpdaterFunction(uriFunc, handlerFunc, preFunc, emptyFunc, errorFunc);
}

function createLiveUpdaterFunction(uriFunc, handlerFunc, preFunc, emptyFunc, errorFunc) {
    var request = false;
    if (window.XMLHttpRequest) {
      request = new XMLHttpRequest();
    }

    function update() {
      if(request && request.readyState < 4)
        request.abort();

      if(!window.XMLHttpRequest)
        request = new ActiveXObject("Microsoft.XMLHTTP");

      preFunc();
      request.onreadystatechange = processRequestChange;
      request.open("GET", uriFunc());
      request.send(null);
      return true;
    }

    function processRequestChange() {
      if(request.readyState == 4) {
      	if (request.status == 200) {
          var xmlDoc = request.responseXML;
          if (xmlDoc.documentElement == null
          		|| !xmlDoc.documentElement.hasChildNodes()
          		|| xmlDoc.firstChild.nodeName == "parsererror") {
          	emptyFunc();
          } else {
            handlerFunc(xmlDoc);
          }
        } else {
          errorFunc();
        }
      }
    }

    return update;
}


//
// AUTOCOMPLETE
//
function autocomplete(id, popupId, targetId, uri, paramName, postFunc, progressStyle, minimumCharacters) {
  var inputField = document.getElementById(id);
  var popup = document.getElementById(popupId);
  var targetField = document.getElementById(targetId);
  if (!postFunc) postFunc = function () {};
  if (minimumCharacters == null || minimumCharacters == "null") minimumCharacters = 1;
  var items = new Array();
  var current = 0;
  var originalPopupTop = popup.offsetTop;
  
  function constructUri() {
    var separator = "?";
    if (uri.indexOf("?") >= 0)
        separator = "&";
    return uri + separator + paramName + "=" + escape(inputField.value);
  }

  function hidePopup() {
    popup.style.visibility = 'hidden';
  }

  function handlePopupOver() {
    removeListener(inputField, 'blur', hidePopup);
  }

  function handlePopupOut() {
    if (popup.style.visibility == 'visible') {
      addListener(inputField, 'blur', hidePopup);
    }
  }

  function handleClick(e) {
    inputField.value = eventElement(e).innerHTML;
    targetField.value = eventElement(e).getAttribute("id");
    popup.style.visibility = 'hidden';
    inputField.focus();
    postFunc();
  }

  function handleOver(e) {
    items[current].className = '';
    current = eventElement(e).index;
    items[current].className = 'selected';
  }

  function handlerFunc(xmlDoc) {
    var root = xmlDoc.documentElement;
    if (root != null) {
      setProgressStyle();

      var items = root.childNodes;

      // Transform item tags to LI tags
      var ul = xmlDoc.createElement("ul");
      for (var i=0; i<items.length; i++) {
        var li = xmlDoc.createElement("li");
        var liIdAttr = xmlDoc.createAttribute("id");
        var liText = xmlDoc.createTextNode(items[i].firstChild.nodeValue);
        li.setAttribute("id", items[i].getAttribute("value"));
        li.appendChild(liText);
        ul.appendChild(li);
      }

      // Remove item tags
      for (var j=items.length-1; j>=0; j--) {
        root.removeChild(root.childNodes[j]);
      }

      // Add UL tag
      root.appendChild(ul);

      // Set innerHTML for popup
      document.getElementById(popupId).innerHTML = flattenChildren(root.childNodes);

      setSelected();
    }
  }

  function setSelected() {
    current = 0;
    items = popup.getElementsByTagName("li");
    if ((items.length > 1)
       || (items.length == 1
           && items[0].innerHTML != inputField.value)) {
      setPopupStyles();
      for (var i = 0; i < items.length; i++) {
        items[i].index = i;
        addOptionHandlers(items[i]);
      }
      items[0].className = 'selected';
    } else {
      popup.style.visibility = 'hidden';
    }

    resetProgressStyle();

    return null;
  }

  function setProgressStyle() {
    if (progressStyle != null) {
      addClass(inputField, progressStyle);
    }
  }

  function resetProgressStyle() {
    if (progressStyle != null) {
      removeClass(inputField, progressStyle);
    }
  }
  
  function empty() {
    resetProgressStyle();
    popup.style.visibility = 'hidden';
  }

  function setPopupStyles() {
    var maxHeight
    if (isIE) {
      maxHeight = 200;
    } else {
      maxHeight = window.outerHeight/3;
    }
    if (popup.offsetHeight < maxHeight) {
      popup.style.overflow = 'hidden';
    } else if (isMoz) {
      popup.style.maxHeight = maxHeight + 'px';
      popup.style.overflow = '-moz-scrollbars-vertical';
    } else {
      popup.style.height = maxHeight + 'px';
      popup.style.overflowY = 'auto';
    }
    popup.scrollTop = 0;
    popup.style.visibility = 'visible';
    
    // Start playing
    popup.style.top = (getElementY(document.getElementById(id))+document.getElementById(id).offsetHeight+2) + "px";
    popup.style.left = getElementX(document.getElementById(id)) + "px";
    popup.style.width = document.getElementById(id).offsetWidth + "px";
  }

  function addOptionHandlers(option) {
    addListener(option, "click", handleClick);
    addListener(option, "mouseover", handleOver);
  }

  var updater = liveUpdater(constructUri, handlerFunc, null, empty);
  var timeout = false;

  function start(e) {
    if (timeout)
      window.clearTimeout(timeout);

    var key = 0;
    if (e.keyCode) { key = e.keyCode; }
    else if (typeof(e.which)!= 'undefined') { key = e.which; }
    var fieldLength = inputField.value.length;

    //up arrow
    if (key == 38) {
      if (current > 0) {
        items[current].className = '';
        current--;
        items[current].className = 'selected';
        items[current].scrollIntoView(false);
      }

    //down arrow
    } else if (key == 40) {
      if(current < items.length - 1) {
        items[current].className = '';
        current++;
        items[current].className = 'selected';
        items[current].scrollIntoView(false);
      }

    //enter or tab
    } else if ((key == 13) && popup.style.visibility == 'visible') {
      inputField.value = items[current].innerHTML;
      targetField.value = items[current].getAttribute("id");
      popup.style.visibility = 'hidden';
      inputField.focus();
      if (isIE) {
        event.returnValue = false;
      } else {
        e.preventDefault();
      }
      postFunc();

    //escape
    } else if (key == 27) {
      hidePopup();
      if (isIE) {
        event.returnValue = false;
      } else {
        e.preventDefault();
      }

    } else {
      // increment/decrement fieldLength for correct count
      if (key == 8 || key == 46) {
        fieldLength -= 1;
      } else {
        fieldLength += 1;
      }

      // Check for empty input field or not enough characters
      if (fieldLength < minimumCharacters) {
        // hide popup and return
        hidePopup();
      } else if (key != 9) {
        timeout = window.setTimeout(updater, 300);
      }
    }
  }

  addKeyListener(inputField, start);
  addListener(popup, 'mouseover', handlePopupOver);
  addListener(popup, 'mouseout', handlePopupOut);
}


//
// SELECT/DROPDOWN POPULATION
//
function populateSelect(id, targetId, uri, paramName, postFunc, emptyFunc, errorFunc) {
  var inputField = document.getElementById(id);
  var targetField = document.getElementById(targetId);
  if (!postFunc) postFunc = function () {};
  if (!emptyFunc) emptyFunc = function () {};
  if (!errorFunc) errorFunc = function () {};

  function constructUri() {
    var separator = "?";
    if (uri.indexOf("?") >= 0)
        separator = "&";
    return uri
      + separator
      + paramName
      + "="
      + escape(inputField.options[inputField.selectedIndex].value);
  }

  function handleChange(e) {
    var updater = liveUpdater(constructUri, handlerFunc, null, emptyFunc, errorFunc);
    var timeout = window.setTimeout(updater, 0);
  }

  function handlerFunc(xmlDoc) {
    var root = xmlDoc.documentElement;

    // clear existing options
    targetField.options.length = 0;

    if (root != null) {
      targetField.disabled = false;
      var items = root.childNodes;
      for (var i=0; i<items.length; i++) {
        targetField.options[i] = new Option(items[i].firstChild.nodeValue, items[i].getAttribute("value"));
      }

      targetField.focus();
      postFunc();
    }
  }

  addListener(inputField, "change", handleChange);
}


//
// ON/OFF TOGGLE
//
function toggle(imgId, targetId, stateId, uri, paramName, imageOn, imageOff, postFunc, emptyFunc, errorFunc) {
  var imageElem = document.getElementById(imgId);
  var targetElem = document.getElementById(targetId);
  var stateIdElem = document.getElementById(stateId);
  if (!postFunc) postFunc = function () {};
  if (!emptyFunc) emptyFunc = function () {};
  if (!errorFunc) errorFunc = function () {};

  function constructUri() {
    var separator = "?";
    if (uri.indexOf("?") >= 0)
        separator = "&";
    return uri
      + separator
      + paramName
      + "="
      + escape(stateIdElem.value);
  }

  function handleClick(e) {
    var updater = liveUpdater(constructUri, handlerFunc, null, emptyFunc, errorFunc);
    var timeout = window.setTimeout(updater, 0);
  }

  function handlerFunc(xmlDoc) {
    var root = xmlDoc.documentElement;

    if (root != null) {
      var items = root.childNodes;
      if (items.length > 0) {
				// fill text (if present)
      	targetElem.innerHTML = items[0].firstChild.nodeValue;

				// replace image
				if ("true".toLowerCase() == (new String(items[0].getAttribute("value"))).toLowerCase()) {
					imageElem.src = imageOn;
					stateIdElem.value = true;
				} else {
					imageElem.src = imageOff;
					stateIdElem.value = false;
				}
      }

      postFunc();
    }
  }

  addListener(imageElem, "click", handleClick);
}


//
// FORM UPDATE
//
function formUpdate(sourceId, targetId, actionId, uri, paramName, postFunc, emptyFunc, errorFunc) {
  var sourceElem = document.getElementById(sourceId);
  var actionElem = document.getElementById(actionId);
  var targets = targetId.split(",");
  if (!postFunc) postFunc = function () {};
  if (!emptyFunc) emptyFunc = function () {};
  if (!errorFunc) errorFunc = function () {};

  function constructUri() {
    var separator = "?";
    if (uri.indexOf("?") >= 0)
        separator = "&";
    return uri
      + separator
      + paramName
      + "="
      + escape(sourceElem.value);
  }

  function handleClick(e) {
    var updater = liveUpdater(constructUri, handlerFunc, null, emptyFunc, errorFunc);
    var timeout = window.setTimeout(updater, 0);
  }

	function selectSingleNodeByAttribute(nodes, attribute, value) {
		var ret = null;
		for (var i=0; i<nodes.length; i++) {
			var attr = nodes[i].getAttribute(attribute);
			if (attr != null && attr == value) {
				ret = nodes[i];
				break;
			}
		}
		return ret;
	}

  function handlerFunc(xmlDoc) {
    var root = xmlDoc.documentElement;

    if (root != null) {
      var items = root.childNodes;
      if (items.length > 0) {
      	for (var i=0; i<targets.length; i++) {
	      	var node = selectSingleNodeByAttribute(items, "value", targets[i]);
      		var field = document.getElementById(targets[i]);
	      	if (node != null && field != null && field.type == "text") {
      			field.value = node.firstChild.nodeValue;
	      	}
      	}
      }

      postFunc();
    }
  }

  addListener(actionElem, "click", handleClick);
}


//
// CALLOUT
//
function callout(anchorId, classNamePrefix, uri, paramName, paramValue,
                 boxPosition, useTitleBar, title, timeout, postFunc, emptyFunc, errorFunc) {

  var anchorElem = document.getElementById(anchorId);
  if (!boxPosition) boxPosition = "top-right";
  if (!timeout) timeout = -1;
  if (!useTitleBar) {
    useTitleBar = false;
  } else {
    useTitleBar =
      ("true" == useTitleBar.toLowerCase() || "yes" == useTitleBar.toLowerCase()) ? true : false;
  }
  if ("null" == title) {
    title = null;
  } else {
    useTitleBar = true;
  }
  var targetElem = constructBox(classNamePrefix);
  if (!postFunc) postFunc = function () {};
  if (!emptyFunc) emptyFunc = function () {};
  if (!errorFunc) errorFunc = function () {};

  function constructUri() {
    var separator = "?";
    if (uri.indexOf("?") >= 0)
        separator = "&";
    if (null == paramName || (null != paramName && null == paramValue)) {
      return uri;
    }
    return uri
      + separator
      + paramName
      + "="
      + escape(paramValue);
  }

  function handleClick(e) {
    var updater = liveUpdater(constructUri, handlerFunc, null, emptyFunc, errorFunc);
    var upTimeout = window.setTimeout(updater, 0);
  }

  function handleCloseClick(e) {
    targetElem.style.display = "none";
    removeListener(this, 'mousemove', handleHover);
    document.releaseEvents(Event.MOUSEMOVE);
  }

  function handlerFunc(xmlDoc) {
    var root = xmlDoc.documentElement;

    if (root != null) {
      var items = root.childNodes;
      if (items.length > 0) {
				// fill text (if present)
        if (useTitleBar) {
          if (!title) {
            targetElem.childNodes[1].innerHTML = items[0].getAttribute("value");
          } else {
            targetElem.childNodes[1].innerHTML = title;
          }
          targetElem.childNodes[2].innerHTML = items[0].firstChild.nodeValue;
        } else {
          targetElem.childNodes[1].innerHTML = items[0].firstChild.nodeValue;
        }
      	
      	// move box to new location
        moveBox(anchorElem, targetElem);

        // bring box to front
        targetElem.style.display = "block";

        if (timeout > 0) {
          window.setTimeout(hookHover, timeout);
        }
      }

      postFunc();
    }
  }

  function constructBox(classNamePrefix) {
    // create base
    var eBox = document.createElement("div");
    eBox.className = classNamePrefix+"Box";
    document.documentElement.appendChild(eBox);

    // add elements
    var eClose = document.createElement("div");
    eClose.className = classNamePrefix+"Close";
    eClose.appendChild(document.createTextNode("X"));
    eBox.appendChild(eClose);

    if (useTitleBar) {
      var eTitle = document.createElement("div");
      eTitle.className = classNamePrefix+"Title";
      eBox.appendChild(eTitle);
    }

    var eContent = document.createElement("div");
    eContent.className = classNamePrefix+"Content";
    eBox.appendChild(eContent);

    eBox.style.display = "none";
    document.getElementById("calloutContainer").appendChild(eBox);
    return eBox;
  }

  function moveBox(anchor, box) {
    var posX = anchor.offsetLeft;
    var posY = anchor.offsetTop;
    box.style.position = "absolute";

    if (boxPosition.indexOf("top") >= 0) {
      box.style.top = (posY - (box.offsetHeight) - 10) + "px";
    } else {
      box.style.top = (posY + (anchor.offsetHeight) + 10) + "px";
    }
    if (boxPosition.indexOf("right") >= 0) {
      box.style.left = (posX + 10) + "px";
    } else {
      box.style.left = (posX - (box.offsetWidth) - 10) + "px";
    }

    // Check for off-screen position
    if (box.offsetLeft < 0) {
      box.style.left = 0;
    }
    if (box.offsetTop < 0) {
      box.style.top = 0;
    }
  }

  function closeOnClick(e) {
  	if (targetElem.style.display != "none") {
      var clickX = e.pageX;
      var clickY = e.pageY;
      var boundX1 = targetElem.offsetLeft;
      var boundX2 = boundX1 + targetElem.offsetWidth;
      var boundY1 = targetElem.offsetTop;
      var boundY2 = boundY1 + targetElem.offsetHeight;
      if (clickX < boundX1 || clickX > boundX2 || clickY < boundY1 || clickY > boundY2) {
      	handleCloseClick();
      }
    }
	}

  function hookHover() {
    document.captureEvents(Event.MOUSEMOVE);
    addListener(this, "mousemove", handleHover);
  }

  function handleHover(e) {
    var clickX = e.clientX;
    var clickY = e.clientY;
    var boundX1 = targetElem.offsetLeft;
    var boundX2 = boundX1 + targetElem.offsetWidth;
    var boundY1 = targetElem.offsetTop;
    var boundY2 = boundY1 + targetElem.offsetHeight;
    if (clickX < boundX1 || clickX > boundX2 || clickY < boundY1 || clickY > boundY2) {
    	handleCloseClick();
    }
  }

  addListener(anchorElem, "click", handleClick);
  addListener(targetElem.childNodes[0], "click", handleCloseClick);
  addListener(this, "click", closeOnClick);
}
