package zielinskin.springboote2e.preferences.api;

import zielinskin.common.logic.CrudService;

public interface StudentPreferenceService extends CrudService<StudentPreference, Integer> {
    ResolvedStudentPreference getResolvedStudentPreference(Integer id);
}
