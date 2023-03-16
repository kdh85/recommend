# 브랜드별 제품의 등록,수정,삭제, 최저가 추천.

### 요건
* 컴퓨터 악세사리 브랜드종류 (A,B,C)가 있다.
* 각 브랜드별 상품의 카테고리 종류는 키보드(KEYBOARD), 마우스(MOUSE), 헤드셋(HEAD_SET), 마우스패드(MOUSE_PAD)가 있다.
* 각 상품에는 상품명, 가격, 상품판매 상태가 있다.
* 브랜드별 상품카테고리별로 가격이다른 제품이 2종류씩 있다고 상정한다.(ex: 브랜드-카테고리-상품명-가격 기준으로  A-KEYBOARD-MODEL1-10000,A-KEYBOARD-MODEL2-15000 인 제품 2가지를 가짐.)


### 요건별 기능 정리.
* 브랜드 등록, 조회, 수정, 삭제에 대한 기능 구현.
* 카테고리별 상품의 등록, 수정, 조회 기능 구현.
  * 상품 조회시 캐쉬 서비스를 활용하여 조회.
  * 상품 조회시 상품명, 가격으로 정렬
  * 상품 검색 키워드 상품명, 상품 카테고리, 상품 가격 구간 검색.(입력 금액 이상 또는 이하)
* 전체 브랜드 기준 각 카테고리별 최저가 상품을 조회 기능 구현.
* 선택 브랜드 기준 최저가 상품 조회 기능 구현.

### 도메인 정리
브랜드
* 브랜드명, 카테고리 목록을 소유.

카테고리
* 카테고리 항목을 소유. 
  * 항목 내용 : 키보드(KEYBOARD), 마우스(MOUSE), 헤드셋(HEAD_SET), 마우스패드(MOUSE_PAD)

상품
* 상품명, 상품 카테고리, 가격, 상품판매 상태를 소유.
