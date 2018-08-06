/**
 * 
 */

/**
 * 显示错误消息
 */
function showinfo(parentNode, info) {
	// alert(parentNode.childNodes[1].nodeName==SPAN)
	if (parentNode.childNodes[1].nodeName == "SPAN") {
		parentNode.removeChild(parentNode.childNodes[1]);
	}
	// 创建节点
	var node = document.createElement("span");
	var textnode = document.createTextNode(info);
	// 添加子节点到父节点
	node.appendChild(textnode);
	node.setAttribute("style", "color:red");
	// 向第一个元素前插入新节点
	parentNode.insertBefore(node, parentNode.childNodes[1]);
}