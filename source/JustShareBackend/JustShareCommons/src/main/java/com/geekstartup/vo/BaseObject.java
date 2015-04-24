/**
 * 
 */
package com.geekstartup.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author tanmoy.banerjee
 *
 */
public class BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9018522340456317781L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
