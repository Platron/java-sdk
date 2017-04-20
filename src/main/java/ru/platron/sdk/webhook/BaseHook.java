package ru.platron.sdk.webhook;

import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "request")
public abstract class BaseHook extends XmlObject {

}
