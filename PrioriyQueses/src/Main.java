class UX {
    printSchedule(finalSchedule, allCourses, allClassrooms) {
        finalSchedule.sort((a, b) => a.getScheduleUnit().getDay().localeCompare(b.getScheduleUnit().getDay()) || a.getScheduleUnit().getLessonHour() - b.getScheduleUnit().getLessonHour());

        console.log("1. SINIF:");
        finalSchedule.forEach(schedule => {
        if (schedule.getCourse().getYear() === 1) {
            console.log(${schedule.getScheduleUnit().getDay()} ${schedule.getScheduleUnit().getLessonHour()} --> ${schedule.getCourse().getCode()} | ${schedule.getClassroom().getName()});
        }
        });

        console.log("\n\n2. SINIF:");
        finalSchedule.forEach(schedule => {
        if (schedule.getCourse().getYear() === 2) {
            console.log(${schedule.getScheduleUnit().getDay()} ${schedule.getScheduleUnit().getLessonHour()} --> ${schedule.getCourse().getCode()} | ${schedule.getClassroom().getName()});
        }
        });

        console.log("\n\n3. SINIF:");
        finalSchedule.forEach(schedule => {
        if (schedule.getCourse().getYear() === 3) {
            console.log(${schedule.getScheduleUnit().getDay()} ${schedule.getScheduleUnit().getLessonHour()} --> ${schedule.getCourse().getCode()} | ${schedule.getClassroom().getName()});
        }
        });

        console.log("\n\n4. SINIF:");
        finalSchedule.forEach(schedule => {
        if (schedule.getCourse().getYear() === 4) {
            console.log(${schedule.getScheduleUnit().getDay()} ${schedule.getScheduleUnit().getLessonHour()} --> ${schedule.getCourse().getCode()} | ${schedule.getClassroom().getName()});
        }
        });

        // Check courses that could not be added to the schedule
        allCourses.forEach(currentCourse => {
                let courseAdded = finalSchedule.some(schedule => schedule.getCourse().getName().toLowerCase() === currentCourse.getName().toLowerCase());
        if (!courseAdded) {
            console.log(\nCourse that cannot be added to the schedule: ${currentCourse.getName()});
            let suitableClassroomFound = allClassrooms.some(classroom => currentCourse.getStudentsNum() <= classroom.getCapacity());
            if (!suitableClassroomFound) {
                console.log(The ${currentCourse.getName()} course could not be added to the schedule because there is no classroom with sufficient capacity.);
                console.log(Number of students taking the ${currentCourse.getName()} course: ${currentCourse.getStudentsNum()});
            }
        }
        });
    }
}