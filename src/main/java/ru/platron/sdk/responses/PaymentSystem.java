package ru.platron.sdk.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

@XmlRootElement(name = "pg_payment_system")
public class PaymentSystem {
	@XmlElement(name = "pg_name")
	public String name;
	
	@XmlElement(name = "pg_ps_data")
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, String> psData = new HashMap<String, String>();
}

class MapAdapter extends XmlAdapter<MapWrapper, Map<String, String>> {

	@Override
	public MapWrapper marshal(Map<String, String> m) throws Exception {
		MapWrapper wrapper = new MapWrapper();
		List<JAXBElement<String>> elements = new ArrayList<JAXBElement<String>>();
		if (m != null && !m.isEmpty()) {
			for (Entry<String, String> property : m.entrySet()) {
				elements.add(new JAXBElement<String>(new QName(property.getKey()), String.class, property.getValue().toString()));
			}
		}
		wrapper.elements = elements;
		return wrapper;
	}

	@Override
	public Map<String, String> unmarshal(MapWrapper v) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if (v != null && v.elements != null && !v.elements.isEmpty()) {
			for (Object object : v.elements) {
				Element element = (Element)object;
				map.put(element.getTagName(), element.getTextContent());
			}
		}
		return map;
	}
	
}

class MapWrapper {
	@XmlAnyElement(lax = true)
	protected List<JAXBElement<String>> elements;
}

