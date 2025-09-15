package zielinskin.springboote2e.preferences.logic;

import org.mapstruct.Mapper;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.preferences.api.StudentPreference;
import zielinskin.springboote2e.preferences.data.StudentPreferenceEntity;

@Mapper(componentModel = "spring")
interface StudentPreferenceMapper  extends BiMapper<StudentPreference, StudentPreferenceEntity> {
}
