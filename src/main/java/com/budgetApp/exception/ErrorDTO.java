package com.budgetApp.exception;

import java.util.List;

public record ErrorDTO(List<String> message, String time) {}

