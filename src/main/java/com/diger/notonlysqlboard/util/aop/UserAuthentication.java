package com.diger.notonlysqlboard.util.aop;

// 커스텀 애노테이션은 프로젝트에 종속적일 수 있다. + 너무 많아지면 어지러워진다.
// 컨트롤러, 메서드마다 다른 권한을 부여해야할 땐 애노테이션 방식이 꽤 편하다.
// 공통 인증-> 필터 (RToken 갱신 등)
// 애노테이션을 만들 땐 영향 범위를 꼼꼼하게 고려해봐야한다.

public @interface UserAuthentication {
}
