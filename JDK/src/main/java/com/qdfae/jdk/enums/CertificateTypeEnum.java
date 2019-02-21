package com.qdfae.jdk.enums;

public enum CertificateTypeEnum {
	
	身份证(2),
	港澳通行证(3),
	台湾通行证(4),
	护照(5),
	军官证(7),
	士官证(8),
	临时身份证(9),
	户口簿(10),
	警官证(11),
	外国人永久居留证(12),
	边民出入境通行证(13),
	组织机构代码(22),
	营业执照(23),
	其他(24);
	
	private int value;
	
	private CertificateTypeEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static CertificateTypeEnum fromValue(int type) {
		for (CertificateTypeEnum item : CertificateTypeEnum.values()) {
			if (item.value == type) {
				return item;
			}
		}
		return null;
	}
	
	public static CertificateTypeEnum fromCertificateTypeName(String name) {
		for (CertificateTypeEnum item : CertificateTypeEnum.values()) {
			if (item.name().equalsIgnoreCase(name)) {
				return item;
			}
		}
		return null;
	}

}
