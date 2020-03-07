Problem:
Please rewrite the following Spring controller to reduce duplication. Hint: use abstract classes.

CommonController:
@Controller
public class CommonController extends AbstractController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ParentService parentService;
	
	@RequestMapping(value = {"/common/searchTeacher"}, method = RequestMethod.GET)
	public @ResponseBody Object searchTeacher(@RequestParam(value = "term") String term) throws Exception {
		PagingDto<Teacher> pagingDto = new PagingDto<Teacher>();
		pagingDto.setResultsPerPage(null);
		pagingDto.setSearch(term);
		List<Teacher> teachers = teacherService.retrieveList(pagingDto, false).getResults();

		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for (Teacher teacher : teachers) {
			Map<String, String> res = new HashMap<String, String>();
			res.put("label", teacher.getExperience());
			res.put("value", teacher.getId());
			ret.add(res);
		}
		
		return ret;
	}

	@RequestMapping(value = {"/common/searchStudent"}, method = RequestMethod.GET)
	public @ResponseBody Object searchStudent(@RequestParam(value = "term") String term) throws Exception {
		PagingDto<Student> pagingDto = new PagingDto<Student>();
		pagingDto.setResultsPerPage(null);
		pagingDto.setSearch(term);
		List<Student> students = studentService.retrieveList(pagingDto, false).getResults();

		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for (Student student : students) {
			Map<String, String> res = new HashMap<String, String>();
			res.put("label", student.getInterests()());
			res.put("value", student.getId());
			ret.add(res);
		}
		
		return ret;
	}

	@RequestMapping(value = {"/common/searchParent"}, method = RequestMethod.GET)
	public @ResponseBody Object searchParent(@RequestParam(value = "term") String term) throws Exception {
		PagingDto<Parent> pagingDto = new PagingDto<Parent>();
		pagingDto.setResultsPerPage(null);
		pagingDto.setSearch(term);
		List<Parent> parents = parentService.retrieveList(pagingDto, false).getResults();
		
		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for (Parent parent : parents) {
			Map<String, String> res = new HashMap<String, String>();
			res.put("label", parent.getEducationHistory());
			res.put("value", parent.getId());
			ret.add(res);
		}
		
		return ret;
	}
	
}
