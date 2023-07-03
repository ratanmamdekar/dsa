package com.machinecoding.contact.management;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
public class Contact {
    String firstName;
    String lastName;
    Long phoneNumber;

}
