package org.example.api.dto;


public record ResponseBookDto(int id, String name) {
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
