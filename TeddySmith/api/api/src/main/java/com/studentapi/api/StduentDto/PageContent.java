package com.studentapi.api.StduentDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageContent
{
  List<StudentDto> content;
  int pageNo;

  int pageSize;

  int total_Element;

  int total_Page;

  boolean isLast;
}
